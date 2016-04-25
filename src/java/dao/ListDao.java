
package dao;

import entity.AddCandidate;
import entity.Mark;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ListDao
{
        public List markList()
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Mark> cList=session.createQuery("SELECT al.markName FROM Mark al").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List<Mark> markListByName(String name)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Mark> cList=session.createQuery("SELECT al FROM Mark al where markName='"+name+"' ").list();
        // List<Category> cList=session.createQuery("SELECT al FROM Category al where lower(catName)='"+name.toLowerCase()+"' ").list();    
        cList.toString();
        session.close();
        return cList;
        
    }
    
    public List allCandidateList()
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<AddCandidate> cList=session.createQuery("select al from AddCandidate al").list();
        cList.toString();
        session.close();
        return cList;
    }
    
}
