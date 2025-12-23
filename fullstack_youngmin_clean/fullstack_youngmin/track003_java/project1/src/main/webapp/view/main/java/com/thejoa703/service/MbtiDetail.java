package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.PostDao;
import com.thejoa703.dto.PostDto;

public class MbtiDetail implements MbtiService {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(    request.getParameter("id")   );
		PostDao dao = new PostDao();
		dao.update_hit(id);
		PostDto result = dao.select(id);
		request.setAttribute("dto", result);
	}

}
