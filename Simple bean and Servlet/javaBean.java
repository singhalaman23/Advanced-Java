package bean;
import java.io.Serializable;
public class javaBean implements Serializable{
    private String name;
    private String addr;
    private String email;
    private String phone;

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

   
    public String getAddr() {
        return addr;
    }

    
    public void setAddr(String addr) {
        this.addr = addr;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPhone() {
        return phone;
    }

   
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
