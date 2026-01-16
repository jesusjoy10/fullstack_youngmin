package spring005_board;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.EmpDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")

public class Test2_Emp {
	@Autowired EmpDao dao;
	
	/*@Ignore@Test public void test1() {
		Map<String, String> para = new HashMap<>();
		para.put("searchType", "ename");
		para.put("keyword", "SMITH");
		System.out.println(dao.test1(para));*/
	
		/*@Test public void test2() {
			EmpDto dto = new EmpDto();
			dto.setEname("SMITH");
			dto.setJob("CLERK");
			System.out.println(dao.test2(dto)); } */
	
/*	@Test public void test3() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		dto.setEname("SMITH");
		dto.setMgr(7902);
		System.out.println(dao.test3(dto)); }  */
	
//	@Test public void test4() {
//		EmpDto dto = new EmpDto();
//		dto.setEname("SMITH");
//		dto.setJob("CLERK");
//		System.out.println(dao.test4(dto)); } 
	
//	@Test public void test5() {
//		EmpDto dto = new EmpDto();
//		dto.setJob("CLERK");
//		dto.setEmpno(7369);
//		System.out.println(dao.test5(dto)); } 
	
	@Test public void test6() {
		List<Integer> list = new ArrayList<>();
		list.add(7369); list.add(7499); list.add(7521);
		
		System.out.println(dao.test6(list));
		
	}
	
	
		
	}


