/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Voter_LoginMB
{
    private String votername;//admin(election commission) name
    private Integer voterid;//admin(election commission) password

    public Integer getVoterid() {
        return voterid;
    }

    public void setVoterid(Integer voterid) {
        this.voterid = voterid;
    }

    
    
    public String getVotername() {
        return votername;
    }

    public void setVotername(String votername) {
        this.votername = votername;
    }

  

    
    public String loginVoter()
    {
        
         boolean status=false;
         PreparedStatement ps = null;
         Connection con = null;
         ResultSet rs=null;
        if(votername.length()!=0)
        {
            try
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting_ms", "root", "12345");
                String insert = "SELECT * from add_voter where voter_name=? and voter_id=?";
                ps = con.prepareStatement(insert);
                ps.setString(1, votername);
                ps.setInt(2, voterid);
                rs = ps.executeQuery();
                status = rs.next();
                
            }
            catch(Exception e)
            {
                
                System.out.println(e.toString());
                
            }
        if(status)
        {
            return"voter_profile";
            
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Error!!!",""));
            
       }
     }
       return null;
    }
    
    
}
