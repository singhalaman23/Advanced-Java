import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CRUD_servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String stuid = request.getParameter("stuid");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String submit = request.getParameter("submit");
            if(submit.equals("Create")){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
                    PreparedStatement st = con.prepareStatement("insert into crud values (?,?,?,?)");
                    st.setString(1,stuid);
                    st.setString(2,firstName);
                    st.setString(3,lastName);
                    st.setString(4,email);
                    int row = st.executeUpdate();
                    if(row==1){
                        out.println("Data Created Successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    }
                    else{
                        out.println("Data creation failed !!!");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    }
                }
                catch(ClassNotFoundException | SQLException e){
                    out.println("Error !!!");
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    
                }
                
            }
            else if(submit.equals("Read")){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
//                    PreparedStatement st = con.prepareStatement("select * from crud where id=(?)");
//                    st.setString(1,id);
                    Statement st=con.createStatement();   
                    ResultSet rs=st.executeQuery("select * from crud where stuid="+stuid);
                    while(rs.next()){
                              out.println(rs.getString(1) +"<br/>"+ rs.getString(2)+"<br/>"+rs.getString(3)+"<br/> "+rs.getString(4));
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                }
                catch(ClassNotFoundException | SQLException e){
                    out.println("error");
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                }
            }
            else if(submit.equals("Update")){
                try{
                     Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
                    PreparedStatement st = con.prepareStatement("UPDATE crud SET firstName=?,lastName=?,email=? where stuid=?");
                    st.setString(4,stuid);
                    st.setString(1,firstName);
                    st.setString(2,lastName);
                    st.setString(3,email);
                    int row = st.executeUpdate();
                    if(row==1){
                        out.println("Data updated Successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                        
                    }
                    else{
                        out.println("Error in data updation");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    }
                }
                catch(ClassNotFoundException | SQLException e){
                    out.println("error");
                }
            }
            else if(submit.equals("Delete")){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
                    PreparedStatement st = con.prepareStatement("DELETE from crud where stuid=?");
                    st.setString(1, stuid);
                    int row = st.executeUpdate();
                    if(row==1){
                        out.println("Data Deleted Successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    }
                    else{
                        out.println("Error in deletion");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request,response);
                    }
                }
                catch(ClassNotFoundException | SQLException e){
                    out.println("error");
                }
            }
    
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CRUD_servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CRUD_servlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
