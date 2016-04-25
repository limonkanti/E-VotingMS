

package addHandler;

import dao.Add_Voting;
import dao.ListDao;
import entity.Mark;
import entity.Voting;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Add_GiveVotingMB 
{
    Voting candidate=new Voting();
    Mark mark=new Mark();
    String markname;
    List<Mark> listmark;

    public Voting getCandidate() {
        return candidate;
    }

    public void setCandidate(Voting candidate) {
        this.candidate = candidate;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getMarkname() {
        return markname;
    }

    public void setMarkname(String markname) {
        this.markname = markname;
    }

    public List<Mark> getListmark() {
        return listmark;
    }

    public void setListmark(List<Mark> listmark) {
        this.listmark = listmark;
    }
    
    
    
    public String addGivingVote()
    {
        
       
        listmark=new ListDao().markListByName(markname);
       // mark.setMarkName(mark.getMarkName());
        mark.setMarkId(listmark.get(0).getMarkId());
        
        candidate.setMark(mark);
        candidate.setVoterId(candidate.getVoterId());
      
        
         boolean status=new Add_Voting().addVoting(candidate);
         if(status)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Congratulations!!! You have given vote Successfully",""));
            
        }
        else
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sorry!!!You have already given vote.",""));
        }
        return null;
        
    }
    public List<SelectItem> getMarkName()
    {
        List<SelectItem> markname=new ListDao().markList();
        return markname;
    }
}
    

