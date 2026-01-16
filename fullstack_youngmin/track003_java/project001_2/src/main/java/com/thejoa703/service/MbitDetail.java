package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dto.PostDao;
import com.thejoa703.dto.PostDto;

public class MbitDetail implements MbtiService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		System.out.println(".......... id" + id);
		//2. dao
		PostDao dao = new PostDao();
		dao.update_hit(id);  // 조회수 올리기
		PostDto result = dao.select(id); //해당번호의 값 가져오기
		System.out.println(".......... result" + result);
		//3. 데이터 넘겨주기
		request.setAttribute("result", result); 
	}

}
