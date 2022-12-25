import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class cookie_servlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Cookie [] cookies = request.getCookies();
            boolean f = false;
            String name = "";
            if(cookies==null){
                out.println("<h1>You are new user, go to home page and write ur name");
                return;
            }
            else{
                for(Cookie c:cookies){
                    String t_name = c.getName();
                    if(t_name.equals("user_name")){
                        f=true;
                        name = c.getValue();
                    }
                }
            }
            if(f){
                out.println("<h1>Hello, welcome to second servlet "+name+"</h1>");
                out.println("Thankyou for using cookies");
            }
            else{
                out.println("<h1>Cookie data not found, go to home page</h1>");
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet cookie_servlet2</title>");            
//            out.println("</head>");
//            out.println("<body>");
////            out.println("<h1>Servlet cookie_servlet2 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }
}
