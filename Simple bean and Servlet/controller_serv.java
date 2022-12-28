//create a package named bean inside source packages
//inside that package, create this servlet file and name it as controller_serv.java
//and inside that bean package only, create a normal java file and name it as javaBean.java

package bean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class controller_serv extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            javaBean bean=new javaBean();
            bean.setName(request.getParameter("name"));
            bean.setAddr(request.getParameter("addr"));
            bean.setEmail(request.getParameter("email"));
            bean.setPhone(request.getParameter("phone"));
            
            out.println("<h1>Name: " + bean.getName() + "</h1>");
            out.println("<h1>Address: " + bean.getAddr() + "</h1>");
            out.println("<h1>Email: " + bean.getEmail() + "</h1>");
            out.println("<h1>Phone: " + bean.getPhone() + "</h1>");
        }
    }
}
