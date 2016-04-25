
package dao;

import entity.AddVoter;
import entity.Mark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class Add_Mark 
{
    
     public boolean addMark(Mark addMark)
    {
        try{
            SessionFactory factory=HibernateUtil.getSessionFactory();
            Session session=factory.openSession();
            session.save(addMark);
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
