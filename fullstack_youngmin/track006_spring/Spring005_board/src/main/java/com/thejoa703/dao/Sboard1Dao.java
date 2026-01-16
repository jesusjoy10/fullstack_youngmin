package com.thejoa703.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.Sboard1Dto;

@MbtiDao
public interface Sboard1Dao {
	public int insert(Sboard1Dto dto);
	public int update(Sboard1Dto dto);
	public int updateHit(int id);
	public int delete(Sboard1Dto dto);
	public List<Sboard1Dto> selectAll();
	public Sboard1Dto      select(int id);
	
	/*upload*/
	public int insert2(Sboard1Dto dto);
	public int update2(Sboard1Dto dto);
	
	/* Ajax */
	public List<Sboard1Dto> selectSearch( HashMap<String, String> para);
	

}
