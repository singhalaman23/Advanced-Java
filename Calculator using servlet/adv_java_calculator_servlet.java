import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adv_java_calculator_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                String first=request.getParameter("first");
                String second=request.getParameter("second");
                String option=request.getParameter("calc");
                int f = Integer.parseInt(first);
                int s = Integer.parseInt(second);
                int ans = 0;
                if(option.equals("add")){
                    ans = f+s;
                }
                else if(option.equals("sub")){
                    ans = f-s;
                }
                else if(option.equals("mul")){
                    ans = f*s;
                }
                else if(option.equals("divi")){
                    ans = f/s;
                }
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
              rd.include(request, response);
//              out.println(ans);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculatorserv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+ans+"</h1>");
            out.println("</body>");
            out.println("</html>");
              
        }
    }
}
