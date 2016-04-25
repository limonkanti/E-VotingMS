
package addHandler;

import dao.Add_Voter;
import entity.AddVoter;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class Add_VoterMB 
{
    AddVoter addvoter=new AddVoter();

    public AddVoter getAddvoter() {
        return addvoter;
    }

    public void setAddvoter(AddVoter addvoter) {
        this.addvoter = addvoter;
    }
     public String addVoter()
    {
        addvoter.setVoterName(addvoter.getVoterName());
        addvoter.setVoterId(addvoter.getVoterId());
        boolean status=new Add_Voter().addVoter(addvoter);
        if(status)
        {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"New voter informations have inserted successfully!!!",""));
        }
        else
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sorry!!! Voter informations have already inserted!!!",""));
            
        }
        return null;
    }
    
    
}
