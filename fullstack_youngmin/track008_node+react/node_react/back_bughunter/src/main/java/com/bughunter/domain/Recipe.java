package com.bughunter.domain;

import lombok.Data;
import java.util.Date;

@Data
public class Recipe {
    private Long recipeId;      // RECIPE_ID
    private Long appuserid;     // APPUSERID (작성자 ID)
    private String title;       // 제목
    private Integer category;   // CATEGORY (숫자로 되어있음!)
    private String image;       // IMAGE
    private Integer cookTime;   // COOK_TIME
    private String difficulty;  // DIFFICULTY (쉬움, 보통, 어려움 등)
    private Integer servings;   // SERVINGS
    private String description; // DESCRIPTION
    private String status;      // STATUS (PUBLIC, PRIVATE 등)
    private Date createdAt;     // CREATED_AT
    private String rUrl;        // R_URL (참고 URL)
    
    // 조인을 통해 가져올 카테고리 이름 (선택 사항)
    private String categoryName; 
}