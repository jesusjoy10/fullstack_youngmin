package com.thejoa703.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.Sboard2Dao;
import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.util.UtilUpload;

public class Sboard2ServiceImpl implements Sboard2Service {
	
	@Autowired Sboard2Dao dao;
	@Autowired UtilUpload upload;
	
	   
  
 @Override  public  int insert(MultipartFile file , Sboard2Dto dto) {
	 if(!file.isEmpty()) {
		 try {dto.setBfile(upload.fileUpload(file));}
		 catch(IOException e) {e.printStackTrace();}
	 }
	return dao.insert(dto);
}  

 @Override public  int update(MultipartFile file , Sboard2Dto dto) {
	 if(!file.isEmpty()) {
		 try {dto.setBfile(upload.fileUpload(file));}
		 catch(IOException e) {e.printStackTrace();}
	 }
	return dao.update(dto);
}	 

 @Override public int delete(Sboard2Dto dto) {
	return 0;
}     

 @Override public List<Sboard2Dto> selectAll() {
	return dao.selectAll();
}	     

 @Override public Sboard2Dto  select(int id) {
	dao.updateHit(id); return dao.select(id);
} 
 @Override  public Sboard2Dto  selectUpdateForm(int id) {
	return dao.select(id);
} 
	   

}
