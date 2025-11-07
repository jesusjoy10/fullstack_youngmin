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
        request.setCharacterEncoding("UTF-8");

        // 파라미터 받기
        String foodIdStr = request.getParameter("foodId");
        String type = request.getParameter("type");
        String feedback = request.getParameter("feedback");

        // foodId가 null이면 등록 안 함
        if (foodIdStr == null || foodIdStr.isEmpty()) {
            System.out.println("foodId가 없습니다. 등록 중단");
            return;
        }

        int foodId = Integer.parseInt(foodIdStr);

        // DTO 생성 및 저장
        SerchDto dto = new SerchDto();
        dto.setFoodId(foodId);
        dto.setType(type);
        dto.setFeedback(feedback);

        SerchDao dao = new SerchDao();
        dao.insert(dto);

        // 등록 후 목록으로 리다이렉트
        response.sendRedirect("list.recommend");
    }
}