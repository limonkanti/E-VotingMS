

package addHandler;

import dao.ResultDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Voting_ResultMB 
{
    
     public List<ResultDao> getVotingResult()
    {
        List<ResultDao> list=new ArrayList<ResultDao>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting_ms", "root", "12345");
            String sql = "SELECT  SUM(voting.mark_id='1') AS Book, SUM(voting.mark_id='2') AS Pen,SUM(voting.mark_id='3') AS Mango  FROM  evoting_ms.voting GROUP BY evoting_ms.voting.mark_id";
// SELECT SUM(voting.mark_id='1') AS PARTY_A, SUM(voting.mark_id='2') AS PARTY_B,SUM(voting.mark_id='3') AS PARTY_C FROM evoting_ms.voting GROUP BY evoting_ms.voting.mark_id;           
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                ResultDao rb=new ResultDao();
                rb.setMark1(rs.getInt(1));
                rb.setMark2(rs.getInt(2));
                rb.setMark3(rs.getInt(3));
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
