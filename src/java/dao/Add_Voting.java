
package dao;

import entity.Voting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class Add_Voting 
{
      public boolean addVoting(Voting givingvote)
    {
       
        try{
            SessionFactory factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();
            session.save(givingvote);
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
