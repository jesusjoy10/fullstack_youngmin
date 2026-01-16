	package com.thejoa703.service;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.thejoa703.dao.SerchDao;
	import com.thejoa703.dto.SerchDto;
	
	public class Recommendwrite implements RecommendService {
	
	    @Override
	    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	
	       
	        int id = Integer.parseInt(request.getParameter("id"));
	        int foodId = Integer.parseInt(request.getParameter("foodId"));
	        String type = request.getParameter("type");
	        String category = request.getParameter("category");
	        String kind = request.getParameter("kind");
	        String method = request.getParameter("method");       
	        String feedback = request.getParameter("feedback");
	
	        SerchDto dto = new SerchDto();
	                
	        dto.setId(id);
	        dto.setFoodId(foodId);
	        dto.setType(type);
	        dto.setCategory(category);
	        dto.setKind(kind);
	        dto.setMethod(method);
	        dto.setFeedback(feedback);
	
	        SerchDao dao = new SerchDao();
	        dao.insert(dto);
	    }
	}
