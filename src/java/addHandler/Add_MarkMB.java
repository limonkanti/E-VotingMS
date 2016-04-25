
package addHandler;

import dao.Add_Mark;
import entity.Mark;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Add_MarkMB
{
    
    Mark mark=new Mark();

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
     public String addMark()
    {
        mark.setMarkName(mark.getMarkName());
        boolean status=new Add_Mark().addMark(mark);
        if(status)
        {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"New Mark Inseted successfully!!!",""));
        }
        else
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Please!!!Enter correct information!!!",""));
            
        }
        return null;
    }
    
}
