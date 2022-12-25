import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if(!validate.checkUser(user,pass)){
                out.println("Incorrect username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request,response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("welcome");
                rd.forward(request,response);
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet loginServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
////            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
        catch(Exception e){
        }
    }
}
