package com.thejoa703.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.mock.web.*;  //## 가짜이미지파일

import com.thejoa703.dao.AppUserMapper;
import com.thejoa703.dto.AppUser;
import com.thejoa703.service.AppUserSecurityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/root-context.xml" , "classpath:config/security-context.xml" })
public class TestDB {
	@Autowired  ApplicationContext  context;
	@Autowired  DataSource  ds;
	@Autowired  SqlSession  sqlSession;
	@Autowired  AppUserMapper  dao;  
	@Autowired  PasswordEncoder   pwencoder;  //org.springframework.security.crypto.password.PasswordEncoder
	@Autowired  AppUserSecurityService  service;  
     
	
	
   @Test  public void test4() {  
		////////////// select
		//				AppUser dto = new AppUser();   dto.setEmail("1@1");
		//				System.out.println(  dao.readAuth(dto)  );
		//		
		////////////// select
		//		AppUser dto = new AppUser();   dto.setEmail("1@1");
		//		System.out.println(  dao.selectPassword(dto)  );
		//		
		////////////// select
		//		AppUser dto = new AppUser();   dto.setEmail("1@1");
		//		System.out.println(  dao.select(dto)  );
		
		////////////// delete
		//		AppUser dto = new AppUser();  dto.setAppUserId(148);  //## 있는번호
		//		System.out.println(dao.delete(dto));   
		
		////////////// update
		//		AppUser dto = new AppUser();    
		//		dto.setMbtiTypeId(2);  dto.setUfile("2.png"); 
		//		dto.setMobile("22222"); dto.setNickname("nickname2");   dto.setAppUserId(148);  //## 있는번호
		//		System.out.println(dao.update(dto)); 
		////////////// insert
						AppUser dto = new AppUser();   
						dto.setEmail("a@a");  dto.setPassword(    pwencoder.encode("a")     );  
						dto.setMbtiTypeId(1);  dto.setUfile("1.png"); 
						dto.setMobile("111111"); dto.setNickname("nickname"); 
						System.out.println(dao.insert(dto)); 
		//////////////
	} 
	 
	  @Test  public void test1() {  System.out.println(context);  }
	  @Test  public void test2() {  System.out.println(ds);  }
	  @Test  public void test3() {  System.out.println(sqlSession);  }

}



