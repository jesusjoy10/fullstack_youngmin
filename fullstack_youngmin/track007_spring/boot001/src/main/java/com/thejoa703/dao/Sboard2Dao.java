package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.Sboard2Dto;
@Mapper
public interface Sboard2Dao {
			    
	    // 전체 목록 조회
	   public List<Sboard2Dto> selectAll();
	    
	    // 글 등록
	   public  int insert(Sboard2Dto dto);
	    
	    // 특정 글 조회
	   public Sboard2Dto  select(int id);
	    
	    // 글 수정
	   public  int update(Sboard2Dto dto);
	    
	    // 글 삭제
	   public int delete(Sboard2Dto dto);

       public int updateHit(int id);


	  

}


