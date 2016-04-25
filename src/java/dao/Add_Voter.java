
package dao;

import entity.AddCandidate;
import entity.AddVoter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class Add_Voter
{
      public boolean addVoter(AddVoter addvoter)
    {
       
        try{
            SessionFactory factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();
            session.save(addvoter);
            session.beginTransaction().commit();
            session.close();
            return true;
            
            
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:\t"+e.toString());
            return false;
            
        }
    }

    
}
