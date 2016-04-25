
package addHandler;

import dao.ResultDao;
import dao.ViewVoterDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class View_VoterMB
{
    
    
     public List<ViewVoterDao> getVoterInfo()
    {
        List<ViewVoterDao> list=new ArrayList<ViewVoterDao>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting_ms", "root", "12345");
            String sql = "SELECT  * from evoting_ms.add_voter";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                ViewVoterDao rb=new ViewVoterDao();
                rb.setVotername(rs.getString(1));
                rb.setVoterid(rs.getInt(2));
                
                list.add(rb);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:\t"+e.toString());
        }
         return list;
    }

}
