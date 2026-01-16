package com.thejoa703.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.SerchDao;
import com.thejoa703.dto.SerchDto;

public class RecommendDetail implements RecommendService {
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터 넘겨받기
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		System.out.println("....." + tableId);
		
		// 2. dao
		SerchDao dao = new SerchDao();		
		SerchDto result = dao.selectByTableId(tableId); 
		System.out.println("....." + result);

		// 3. 데이터 넘겨주기
		request.setAttribute("dto", result);
		
		request.getRequestDispatcher("recommendType/edit.jsp").forward(request, response);
    }
}
