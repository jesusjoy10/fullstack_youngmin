package com.thejoa703.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.PostDao;
import com.thejoa703.dto.PostDto;

public class RecommendSelect implements RecommendService {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 1. 데이터 넘겨받기
        int id = Integer.parseInt(request.getParameter("id"));

        // 2. DAO 호출
        PostDao dao = new PostDao();
        PostDto dto = dao.select(id); // 추천 하나 조회

        // 3. JSP로 넘겨주기
        request.setAttribute("dto", dto);
    }
}
