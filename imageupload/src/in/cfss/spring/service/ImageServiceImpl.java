package in.cfss.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cfss.spring.dao.ImageDao;
import in.cfss.spring.model.Image;

@Service("imageservice")
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageDao imageDao;
	public String addImg(String filename){
		return imageDao.addImg(filename);
	}
	 public List<Image>entirelist(){
		 return imageDao.entirelist();
	 }

}
