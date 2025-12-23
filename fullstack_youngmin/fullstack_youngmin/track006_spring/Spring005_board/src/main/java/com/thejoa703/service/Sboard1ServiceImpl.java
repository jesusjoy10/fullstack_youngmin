package com.thejoa703.service;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.Sboard1Dao;
import com.thejoa703.dto.Sboard1Dto;

@Service
public class Sboard1ServiceImpl  implements Sboard1Service {
	@Autowired Sboard1Dao dao;
				
	
	public int insert(Sboard1Dto dto) {
		try {dto.setBip( InetAddress.getLocalHost().getHostAddress()); }
		catch(UnknownHostException e ) {e.printStackTrace();}
		return dao.insert(dto);
		}
	 public List<Sboard1Dto> selectAll() { return dao.selectAll(); }
	   public Sboard1Dto select(int id)  { dao.updateHit(id); return dao.select(id); }
	   public Sboard1Dto selectUpdateForm(int id) { return dao.select(id); }
	   public int update(Sboard1Dto dto)   { return dao.update(dto); }
	   public int delete(Sboard1Dto dto)   { return dao.delete(dto); }  
	   
		/* Upload */
	   @Override public int insert2(MultipartFile file, Sboard1Dto dto) {
		   if(!file.isEmpty()) { //파일이 비어있는게 아니라면
			   String fileName = file.getOriginalFilename(); //원본 파일
			   String uploadPath = "C:/file/";
			   File img = new File(uploadPath+fileName);
			   try {
				   file.transferTo(img); //파일 올리기
				   dto.setBfile(fileName);
			   	   	}catch (IOException e) {e.printStackTrace();}
		   }
		   try {dto.setBip(InetAddress.getLocalHost().getHostAddress());}
		   catch(UnknownHostException e) {e.printStackTrace();}
		   return dao.insert2(dto);
	   }	
	   
	   /* Search - Ajax */
	   public List<Sboard1Dto> SelectSearch(String keyword){
		   HashMap<String,String>para=new HashMap<>();
		   para.put("search", "%" + keyword + "%"); // keyword가 포함되어 있는
		   return dao.selectSearch(para);
	   }
//	@Override
//	public int update2(MultipartFile file, Sboard1Dto dto) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	 
	   @Override public int update2(MultipartFile file, Sboard1Dto dto) {
		   //기존에 bfile 이 있어서 값이 처리됨 
		   if(!file.isEmpty()) { //파일이 비어있는게 아니라면
			   String fileName = file.getOriginalFilename(); //원본 파일
			   String uploadPath = "C:/file/";
			   File img = new File(uploadPath+fileName);
			   try {
				   file.transferTo(img); //파일 올리기
				   dto.setBfile(fileName);
			   	   	}catch (IOException e) {e.printStackTrace();}
		   }		  
		   return dao.update2(dto);
	   }
	
	   
	   
	
}