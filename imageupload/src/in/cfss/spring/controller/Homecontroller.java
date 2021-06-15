package in.cfss.spring.controller;
import in.cfss.spring.model.Image;
import in.cfss.spring.service.ImageService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Controller
@RequestMapping()
public class Homecontroller {
	@Autowired
	 ImageService imageservice;
	 private static final String UPLOAD_DIRECTORY ="\\images";  
	 
	 @RequestMapping(value ="uploadform",method=RequestMethod.GET)
	   public String uploadForm(Model m){ 
	        return "fileupload";    
	    }  
	    @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public String saveimage(@RequestParam CommonsMultipartFile file,HttpSession session ,Model m) throws Exception{  
	  try{
	    ServletContext context = session.getServletContext();  
	    String path =context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	    System.out.println(path+" "+filename);
	    String s=imageservice.addImg(filename);
	    byte[] bytes =file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(
	    new FileOutputStream(
	    new File(path+File.separator+filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close(); 
	    String r="File successfully saved!";
	    m.addAttribute("filesuccess",r);
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	 return "saves";
	    }  
	  @RequestMapping(value = "view")
	  public String viewemp(Model m) {
			List<Image>viewlist =imageservice.entirelist();
			System.out.println("----viewlist----:"+viewlist);
			m.addAttribute("viewlist", viewlist);
			return "viewtab";
		}
		}
     