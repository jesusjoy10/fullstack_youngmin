package com.thejoa703.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.SerchDao;
import com.thejoa703.dto.SerchDto;

public class RecommendUpdate implements RecommendService {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            SerchDto dto = new SerchDto();
            dto.setTableId(Integer.parseInt(request.getParameter("tableId")));
            dto.setId(Integer.parseInt(request.getParameter("id")));
            dto.setFoodId(Integer.parseInt(request.getParameter("foodId")));
            dto.setType(request.getParameter("type"));
            dto.setCategory(request.getParameter("category"));
            dto.setKind(request.getParameter("kind"));
            dto.setMethod(request.getParameter("method"));
            dto.setFeedback(request.getParameter("feedback"));

            SerchDao dao = new SerchDao();
            int result = dao.update(dto);

            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}