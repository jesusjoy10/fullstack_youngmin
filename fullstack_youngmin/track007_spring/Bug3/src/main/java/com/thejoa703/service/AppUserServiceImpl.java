package com.thejoa703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.util.UtilUpload;

@Service
public class AppUserServiceImpl  implements AppUserService{

	@Autowired private AppUserDao userDao;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UtilUpload  utilUpload;
	
	/* insert,update 파일업로드(공통) */
	private String uploadFile(MultipartFile file, String existingFile) {
		if(file != null &&  !file.isEmpty()) { // 파일존재한다면
			try { return  utilUpload.fileUpload(file); }
			catch (IOException e) {  throw new RuntimeException("파일 업로드 실패" , e); }
		}
		return existingFile;
	}
	@Transactional 
	@Override public int insert(MultipartFile file, AppUserDto dto) { 
		//1. 파일업로드
		dto.setProvider("local");  //회사계정
		dto.setPassword( passwordEncoder.encode(dto.getPassword())  );  //암호화
		dto.setUfile(uploadFile( file, null ));  // 파일업로드
		if(userDao.iddoubleByEmail(dto) > 0) { throw new IllegalStateException("이미 존재하는 계정입니다."); }
		//2. 유저insert
		int result = userDao.insertAppUser(dto);
		//3. 권한insert
		if(result > 0) { userDao.insertAuth( new AuthDto(  dto.getEmail() , "ROLE_MEMBER")); }
		return result; 
	}
	@Transactional
	@Override
	public int update(MultipartFile file, AppUserDto dto) {

	    // ❗ provider를 임의로 local로 바꾸면 안 됨
	    AppUserDto dbUser = userDao.findByEmail(
	        new AppUserDto(dto.getEmail(), dto.getProvider())
	    );

	    if (dbUser == null) {
	        return 0;
	    }

	    // 🔐 local 계정만 비밀번호 검증
	    if ("local".equals(dbUser.getProvider())) {
	        if (dto.getPassword() == null ||
	            !passwordEncoder.matches(dto.getPassword(), dbUser.getPassword())) {
	            return 0;
	        }
	    }

	    // 업데이트용 값 세팅
	    dto.setAppUserId(dbUser.getAppUserId());
	    dto.setProvider(dbUser.getProvider());          // 🔥 유지
	    dto.setUfile(uploadFile(file, dbUser.getUfile()));
	    dto.setNickname(dto.getNickname() != null ? dto.getNickname() : dbUser.getNickname());
	    dto.setMobile(dto.getMobile() != null ? dto.getMobile() : dbUser.getMobile());
	    dto.setPassword(dbUser.getPassword());          // 비번 변경 안 함

	    return userDao.updateAppUser(dto);
	}

	
	@Transactional
	@Override public int delete(AppUserDto dto, boolean requirePasswordCheck) { 
		AppUserDto  dbUser = userDao.findByEmail(dto);
		if( dbUser == null ) { return 0; }
		
		if(requirePasswordCheck) {  //local
			if( dto.getPassword() == null ||  !passwordEncoder.matches(dto.getPassword(), dbUser.getPassword()) ) {
				return 0;
			}
		}
		
		dto.setAppUserId(dbUser.getAppUserId());
		userDao.deleteAuth(  new AuthDto(  dto.getEmail() , "ROLE_MEMBER")   );  //권한삭제
		
		return userDao.deleteAppUser(dto); 	 //유저삭제
	}
	
	@Override public AppUserAuthDto readAuth(String email, String provider) { 
		return userDao.readAuthByEmail(  new AppUserDto(  email, provider)  ); 
	}
	@Override public AppUserDto selectEmail(String email, String provider) { 
		return userDao.findByEmail(  new AppUserDto(  email, provider)  ); 
	}
	@Override public int iddouble(String email, String provider) { 
		return userDao.iddoubleByEmail(  new AppUserDto(  email, provider)  ); 
	}
	@Override public boolean matchesPassword(String email, String provider, String rawPassword) { 
		AppUserDto  dbUser = userDao.findByEmail(new AppUserDto(  email, provider));  //dbUser찾기
		return  dbUser  !=null  &&  dbUser.getPassword() !=null &&
				passwordEncoder.matches(rawPassword , dbUser.getPassword());  // db비번과 매칭하는 user가 true
				
	}
}






