import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class session_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String n = request.getParameter("username");
            out.println("Welcome " + n);
            HttpSession session = request.getSession();
            session.setAttribute("uname",n);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet session_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='session_servlet2'> Link</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
