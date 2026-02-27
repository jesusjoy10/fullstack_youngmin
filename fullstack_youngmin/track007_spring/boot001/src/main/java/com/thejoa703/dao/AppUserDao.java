package com.thejoa703.dao;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;

@Mapper
public interface AppUserDao {
	
	public int insertAppUser(AppUserDto dto);
	public AppUserAuthDto readAuthByEmail(AppUserDto dto);
	public AppUserDto  findByEmail(AppUserDto dto);
	public int iddoubleByEmail(AppUserDto dto);
	public int updateAppUser(AppUserDto dto);
	public int deleteAppUser(AppUserDto dto);
	
	/* 권한관련 */
	public  int insertAuth(AuthDto dto);
	public  int deleteAuth(AuthDto dto);

}


/*
 * Q1. 테이블확인
Q2. Dto
Q3. Dao.

1. 회원가입
2-1.로그인 (이메일로 이메일, 비밀번호, 권한가져오기)
2-2. 이메일로 유저정보찾기
2-3. 이메일로 아이디 중복검사
3. 회원수정
4. 회원삭제

5. 권한삽입
6. 권한삭제
*/
 