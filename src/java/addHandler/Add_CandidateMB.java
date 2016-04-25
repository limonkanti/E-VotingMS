
package addHandler;

import dao.Add_Candidate;
import dao.ListDao;
import entity.AddCandidate;
import entity.AddCandidate1;
import entity.Mark;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;


@ManagedBean
@SessionScoped
public class Add_CandidateMB 
{
    AddCandidate1 candidate1=new AddCandidate1();
    Mark mark=new Mark();
    String markname;
    
    List<Mark> listmark;
    UploadedFile file;
   

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

   
    
    public AddCandidate1 getCandidate() {
        return candidate1;
    }

    public void setCandidate1(AddCandidate candidate) {
        this.candidate1 = candidate1;
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
     public String addCandidate()
    {
        
        upload_candidate_image();
        listmark=new ListDao().markListByName(markname);
        mark.setMarkName(markname);
        
        candidate1.setMarkName(markname);
        candidate1.setCandidateName(candidate1.getCandidateName());
      
        
         boolean status=new Add_Candidate().addCandidate(candidate1);
         if(status)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Data Saved Successfully",""));
            
        }
        else
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sorry!!!Data haven't Saved",""));
        }
        return null;
        
    }
     
         public void upload_candidate_image() {

        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletcontext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                InputStream inputStrim = file.getInputstream();
                String path = mainURLPath + "\\web\\resources\\images\\" + file.getFileName();
                File destFile = new File(path); 
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStrim, destFile);
                }
                candidate1.setCandidateImage(file.getFileName().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
   
    public List<SelectItem> getMarkName()
    {
        List<SelectItem> markname=new ListDao().markList();
        return markname;
    }
    
}
