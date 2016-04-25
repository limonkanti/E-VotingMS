
package dao;


import entity.AddCandidate;
import entity.AddCandidate1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class Add_Candidate 
{
     public boolean addCandidate(AddCandidate1 addcandidate)
    {
       
        try{
            SessionFactory factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();
            session.save(addcandidate);
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
