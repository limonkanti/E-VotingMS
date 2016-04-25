
package addHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class Admin_LoginMB
{
    private String name;//admin(election commission) name
    private String pass;//admin(election commission) password

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String loginAdmin()
    {
        
         boolean status=false;
         PreparedStatement ps = null;
         Connection con = null;
         ResultSet rs=null;
        if(name.length()!=0&&pass.length()!=0)
        {
            try
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting_ms", "root", "12345");
                String insert = "SELECT admin_name,admin_password from admin where admin_name=? and admin_password=?";
                ps = con.prepareStatement(insert);
                ps.setString(1, name);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                status = rs.next();
                
            }
            catch(Exception e)
            {
                
                System.out.println(e.toString());
                
            }
        if(status)
        {
            return"ec_profile";
            
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error!!!",""));
            
       }
     }
       return null;
    }
    
    
}
