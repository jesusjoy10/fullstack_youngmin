package spring005_board;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.service.AppUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/root-context.xml", "classpath:config/security-context.xml"})

public class Test3_Member {
	@Autowired ApplicationContext context;
	@Autowired DataSource ds;
	@Autowired SqlSession session;
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Test public void test8() {
		//4. 유저읽어오기
		AppUserAuthDto rdto = new AppUserAuthDto();
		rdto.setEmail("1@1");
		System.out.println(dao.readAuth(rdto));
		//3. 권한멤버
//		AuthDto adto = new AuthDto();
//		adto.setEmail("1@1"); adto.setAuth("ROLE_MEMBER");
//		System.out.println(dao.insertAuth(adto));
		//2. 회원가입 
//		AppUserDto dto = new AppUserDto();
//		dto.setEmail("1@1"); dto.setPassword(pwencoder.encode("1")); dto.setMbtiTypeId(1);
//		System.out.println("2." + dao.insert(dto));
		//1. 전체
//		System.out.println(dao.selectAll());
	}
	

}
