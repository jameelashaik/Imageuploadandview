package in.cfss.spring.dao;

import in.cfss.spring.model.Image;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("imageDao")
public class ImageDaoImpl implements ImageDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public String addImg( String filename){
		String Status=null;
		System.out.println("filename-------"+filename);
		String sql="INSERT INTO public.imageupload(photo)VALUES('"+filename+"')";
		System.out.println("----sql----:"+sql);
		int result= jdbcTemplate.update(sql);
		if(result>0){
        	Status="Success";
        }
        else{
        	Status="Failure";
        }
		return Status;
		
	}
	public List<Image>entirelist(){
		 String sql = "SELECT * FROM public.imageupload";
	        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Image.class));
	}

}
