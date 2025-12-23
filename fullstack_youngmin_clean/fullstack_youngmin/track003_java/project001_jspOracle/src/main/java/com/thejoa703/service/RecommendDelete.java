package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.SerchDao;
import com.thejoa703.dto.SerchDto;

public class RecommendDelete implements RecommendService {
	   @Override
	    public void exec(HttpServletRequest request, HttpServletResponse response) {
	        int tableId = Integer.parseInt(request.getParameter("tableId"));
	        SerchDto dto = new SerchDto();
	        dto.setTableId(tableId);

	        SerchDao dao = new SerchDao();
	        int result = dao.delete(dto); // 삭제 결과: 1이면 성공

	        request.setAttribute("deleteResult", result); // 삭제 결과를 request에 담아서 넘김
	    }
	}
