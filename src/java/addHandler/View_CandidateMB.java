
package addHandler;

import dao.ViewCandidateDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class View_CandidateMB 
{
      public List<ViewCandidateDao> getCandidateInfo()
    {
        List<ViewCandidateDao> list=new ArrayList<ViewCandidateDao>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting_ms", "root", "12345");
            String sql = "SELECT  evoting_ms.add_candidate1.candidate_name,evoting_ms.add_candidate1.mark_name,evoting_ms.add_candidate1.candidate_image from evoting_ms.add_candidate1;     ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                ViewCandidateDao rb=new ViewCandidateDao();
                rb.setCandidate_name(rs.getString(1));
                rb.setMark_name(rs.getString(2));
                rb.setCandidate_image(rs.getString(3));
                
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
