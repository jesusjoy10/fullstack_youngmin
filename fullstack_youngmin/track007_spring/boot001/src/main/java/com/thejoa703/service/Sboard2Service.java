package com.thejoa703.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.Sboard2Dto;

public interface Sboard2Service {
			    
	   
	    // 글 등록
	   public  int insert(MultipartFile file , Sboard2Dto dto);	    		    
	    // 글 수정
	   public  int update(MultipartFile file , Sboard2Dto dto);	 	   
	   // 글 삭제
	   public int delete(Sboard2Dto dto);	   
	   // 전체 목록 조회
	   public List<Sboard2Dto> selectAll();	    	   
	    // 상세보기 + 조회수 올리기
	   public Sboard2Dto  select(int id);
	   // 수정하기 폼 
	   public Sboard2Dto  selectUpdateForm(int id);	   
	   /* paging */
	   public List<Sboard2Dto> select10(int pageNo);
	   public int selectTotalCnt();
	   /* paging + Search */
	   public  List<Sboard2Dto> select3(String search, int pageNo);
	   public int  selectSearchTotalCnt(String keyword);
	   
	   
	   

	
	   
		   
	   


	  

}


