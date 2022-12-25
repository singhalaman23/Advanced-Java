import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class cookie_servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            out.println("<h1>Hello"+name+"</h1>");
            Cookie c = new Cookie("user_name",name);
            c.setMaxAge(0); 
            response.addCookie(c);

            out.println("<a href='cookie_servlet2'>Go to servlet 2</a></h1>");

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet cookie_servlet1</title>");            
//            out.println("</head>");
//            out.println("<body>");
////            out.println("<h1>Servlet cookie_servlet1 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }
}
