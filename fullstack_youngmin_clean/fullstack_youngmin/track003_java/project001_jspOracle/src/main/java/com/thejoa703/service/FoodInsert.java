package com.thejoa703.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.SerchDao;
import com.thejoa703.dto.SerchDto;

public class FoodInsert implements RecommendService {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 1. 파라미터 받기
            String name = request.getParameter("name");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            int kcal = Integer.parseInt(request.getParameter("kcal"));
            double protein = Double.parseDouble(request.getParameter("protein"));
            double carb = Double.parseDouble(request.getParameter("carb"));
            double fat = Double.parseDouble(request.getParameter("fat"));
            String recipe = request.getParameter("recipe");
            String imageUrl = request.getParameter("imageUrl");

            // 2. DTO 생성
            SerchDto dto = new SerchDto();
            dto.setName(name);
            dto.setCategoryId(categoryId);
            dto.setKcal(kcal);
            dto.setProtein(protein);
            dto.setCarb(carb);
            dto.setFat(fat);
            dto.setRecipe(recipe);
            dto.setImageUrl(imageUrl);

            // 3. DB 저장
            SerchDao dao = new SerchDao();
            dao.insert(dto);

            // 4. 방금 등록한 음식 다시 조회
            int newFoodId = dao.getLatestFoodId();
            SerchDto inserted = dao.selectByTableId(newFoodId);

            // 5. JSP로 넘기기
            request.setAttribute("dto", inserted);
            request.getRequestDispatcher("food/foodDetail.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
