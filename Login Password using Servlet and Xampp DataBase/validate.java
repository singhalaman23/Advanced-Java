import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
public class validate extends HttpServlet {
    public static boolean checkUser(String user, String pass)throws ClassNotFoundException{
        boolean st = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
//            In the above line, i.e. the "/login" part, this login is the name of the database, and not the table name
            PreparedStatement ps = con.prepareStatement("select * from login where UserID=? and password=?");
//            In the above line, login is the name of the table, hence, in this project, the name of table and database is same, i.e. login
            ps.setString(1,user);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            
        }
        catch(ClassNotFoundException | SQLException e){
        }
        return st;
    }
}
