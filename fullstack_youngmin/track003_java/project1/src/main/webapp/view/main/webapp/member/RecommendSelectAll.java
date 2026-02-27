package com.thejoa703.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.PostDao;

public class RecommendSelectAll implements RecommendService {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

		//1. 데이터 넘겨받기
		int id = Integer.parseInt(request.getParameter("recId"));
		//2. 드커프리 (PostDao)
		  
	      PostDao dao = new PostDao(); 
	      
		
		//3. 데이터 넘겨주기
	      request.setAttribute("list", dao.selectAll());


	}

}
