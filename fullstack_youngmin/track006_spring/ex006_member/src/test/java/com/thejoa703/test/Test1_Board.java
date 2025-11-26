package com.thejoa703.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@RunWith(SpringJUnit4ClassRunner.class) //1. 스프링구동
@ContextConfiguration(locations = "classpath:config/root-context.xml") // 2.설정
public class Test1_Board {
	@Autowired ApplicationContext context;
	@Autowired DataSource ds;
	@Autowired SqlSession session;
	@Autowired  AppUserDao  dao;
	@Autowired  AppUserService  service; 
	
	@Ignore@Test public void  test1() {System.out.println(context);}
	@Ignore@Test public void  test2() {System.out.println(ds);}
	@Ignore@Test public void  test3() {System.out.println(session);}
	

		
	
	@Test public void test7() {
		//4. 삭제
		AppUserDto dto = new AppUserDto();
		dto.setAppUserId(67);		
		System.out.println(dao.updateAdmin(dto));
		//3. 해당값유저확인
		System.out.println(dao.select(67));
		//2. 수정
//		AppUserDto dto = new AppUserDto();
//		dto.setMbtiTypeId(3); dto.setAppUserId(67);		
//		System.out.println(dao.updateAdmin(dto));
		//1. 전체
		System.out.println(dao.selectAll());
		
	}
	
	@Ignore@Test public void test6() {
		System.out.println(dao.iddouble("1@1")); //1		
		System.out.println(dao.iddouble("9@9")); //0
	}
	
	@Ignore@Test public void  test4() {
		AppUserDto dto = new AppUserDto();
		dto.setPassword("1"); dto.setAppUserId(47);
		System.out.println("6."+ dao.delete(dto));
	
	//.....................
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1");    dto.setMbtiTypeId(2);  dto.setAppUserId(47);
//	System.out.println("5. " + service.update(dto));
	//.....................
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("c@c");  dto.setPassword("1111");
//	System.out.println("4. " + service.selectLogin(dto));
	//.....................
	//System.out.println("3. " + dao.select(47)); 
//	//.....................
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("c@c");  dto.setPassword("1111");  dto.setMbtiTypeId(1);
//	System.out.println("2. " + service.insert(dto)); 
//	//.....................
	System.out.println("1. " + service.selectAll());
}	
	}
	

	
	


