package com.thejoa703.dao;

import java.util.List;

import com.thejoa703.dto.AppUserDto;

@MbtiDao
public interface AppUserDao {
	public int insert(AppUserDto dto);
	public int update(AppUserDto dto);
	public int delete(AppUserDto dto);
	public List<AppUserDto> selectAll();
	public AppUserDto select(int appUserId);
	public AppUserDto selectEmail(String email);
	public int selectLogin(AppUserDto dto); 
}
