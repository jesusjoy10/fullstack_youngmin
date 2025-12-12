package com.thejoa703;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.thejoa703.dao.Sboard2Dao;
import com.thejoa703.dto.BasicDto;
import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.service.Sboard2Service;
import com.thejoa703.service.TestService;



@SpringBootTest
class Boot001ApplicationTests {
	@Autowired TestService service;
	@Autowired Sboard2Dao dao;
	@Autowired Sboard2Service boardService;
	
	@Test
	public void test4_paging() {
		//1. 10개씩 가져오기
		HashMap<String, Integer> para= new HashMap<>();
		para.put("start", 1);
		para.put("end", 10);
		System.out.println("............." + dao.select10(para));
		
		//2. 전체갯수
		System.out.println("............." + dao.selectTotalCnt());
		
		//3. 검색어 + 3개씩 가져오기
		HashMap<String,Object>para2 =new HashMap<>();
		para2.put("search", "t");
		para2.put("start", 1);
		para2.put("end", 3);
		System.out.println("......." + dao.select3(para2));
		
		//4. 검색어 + 3개씩 가져오기
	    System.out.println("........." + dao.selectSearchTotalCnt("t"));
	}
	
	@Disabled @Test 
	public void test3_sboardService() throws UnknownHostException{
		/*
		//1. selectAll
     	System.out.println(dao.selectAll());
     	 
     	//2. insert
     	Sboard2Dto dto = new Sboard2Dto();
     	dto.setAppUserId(1);  dto.setBtitle("title");   dto.setBcontent("content");  dto.setBpass("1111");
     	MockMultipartFile file = new MockMultipartFile("file2" , "file2.txt","text/plain", "".getBytes());
     	dto.setBip(  InetAddress.getLocalHost().getHostAddress()  );   
     	System.out.println(boardService.insert(file,dto));


     	//3. select
     	System.out.println(boardService.select(1));
     	
     	//4. update
     	Sboard2Dto dto_u = new Sboard2Dto();
     	dto_u.setBtitle("title-new");   dto_u.setBcontent("content-new");  dto_u.setBpass("1111");  dto_u.setId(1);
     	MockMultipartFile u_file = new MockMultipartFile("file2" , "file2.txt","text/plain", "".getBytes());
     	System.out.println(boardService.update(u_file, dto_u));
     	 
     	//5. delete
//     	Sboard2Dto dto_d = new Sboard2Dto();
//     	dto_d.setBpass("1111");  dto_d.setId(1);
//     	System.out.println(boardService.delete(dto_d));
  */
 
	}
	
	
	
	 @Disabled @Test void contextLoads() { // Junit4:@ignore  5:@Disabled
		BasicDto dto = new BasicDto();
		dto.setName("bbosong");
		dto.setAge(2);
		System.out.println("........"+ dto.getName());
		System.out.println("........"+ dto.getAge());

	}
	 @Disabled @Test void serviceTest() { System.out.println("........" + service.readTime());}
	 @Disabled  @Test public void test2() throws UnknownHostException{
			/*
			 * //1. selectAll System.out.println(dao.selectAll());
			 * 
			 * //2. insert Sboard2Dto dto = new Sboard2Dto(); dto.setAppUserId(1);
			 * dto.setBtitle("title"); dto.setBcontent("content"); dto.setBpass("1111");
			 * dto.setBip( InetAddress.getLocalHost().getHostAddress() );
			 * System.out.println(dao.insert(dto));
			 * 
			 * 
			 * //3. select System.out.println(dao.select(1));
			 * 
			 * //4. update Sboard2Dto dto_u = new Sboard2Dto();
			 * dto_u.setBtitle("title-new"); dto_u.setBcontent("content-new");
			 * dto_u.setBpass("1111"); dto_u.setId(1);
			 * System.out.println(dao.update(dto_u));
			 * 
			 * //5. delete Sboard2Dto dto_d = new Sboard2Dto(); dto_d.setBpass("1111");
			 * dto_d.setId(1); System.out.println(dao.delete(dto_d));
			 */
    	 
    	 
    	 
     }
}
