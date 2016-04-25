
package addHandler;


import dao.ListDao;
import entity.AddCandidate;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class DisplayCandidateMB 
{
    AddCandidate candidate=new AddCandidate();

    public AddCandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(AddCandidate candidate) {
        this.candidate = candidate;
    }
    public List<AddCandidate> getAllCandidate()
    {
        List<AddCandidate> plist=new ListDao().allCandidateList();
        return plist;
    }
    
}
