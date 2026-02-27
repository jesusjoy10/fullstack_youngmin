package com.thejoa703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.AppUserDto;

public interface AppUserService {

    public int insert(AppUserDto dto);
    public int update(AppUserDto dto);
    public int delete(AppUserDto dto);
    public  AppUserDto select(int appUserId);
    public  AppUserDto selectEmail(String email);
    public  int selectLogin(AppUserDto dto);
    public List<AppUserDto> selectAll();
	int insert2(MultipartFile file, AppUserDto dto);
	int update2(MultipartFile file, AppUserDto dto);
	int iddouble(String email);
	public int deleteAdmin(AppUserDto dto);
	public int updateAdmin(AppUserDto dto);
	
}
