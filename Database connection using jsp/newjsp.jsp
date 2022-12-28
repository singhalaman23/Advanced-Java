<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            boolean st = false;
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            String ans = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
            PreparedStatement ps = conn.prepareStatement("select * from login where UserID=? and password=? ");
            ps.setString(1,name);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            if(st){
            ans = "success";
            }
            else{
            ans = "fail";
            }
        
        
        %>
        <h1>Hello <%out.println(ans);%></h1>
    </body>
</html>
