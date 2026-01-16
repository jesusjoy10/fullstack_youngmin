package com.thejoa703.dto;

import java.sql.Date;

public class SerchDto {
    private int tableId;      // 추천 고유번호
    private int id;           // 사용자 ID
    private int foodId;       // 음식 ID
    private String type;      // 추천 유형
    private String category;  // 음식 대분류
    private String kind;      // 음식 종류
    private String method;    // 조리 방식
    private String feedback;  // AI 피드백
    private Date createdAt;   // 추천 일시

    // 음식 정보 (FOODTB)
    private String name;         // 음식명
    private int categoryId;      // 카테고리 ID
    private int kcal;
    private double protein;
    private double carb;
    private double fat;
    private String recipe;
    private String imageUrl;
    private Date regDate;

    public SerchDto() {}

    // 추천 정보 생성자
    public SerchDto(int tableId, int id, int foodId, String type, String category, String kind, String method, String feedback, Date createdAt) {
        this.tableId = tableId;
        this.id = id;
        this.foodId = foodId;
        this.type = type;
        this.category = category;
        this.kind = kind;
        this.method = method;
        this.feedback = feedback;
        this.createdAt = createdAt;
    }

    // 음식 정보 생성자
    public SerchDto(int foodId, String name, int categoryId, int kcal, double protein, double carb, double fat, String recipe, String imageUrl, Date regDate) {
        this.foodId = foodId;
        this.name = name;
        this.categoryId = categoryId;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.recipe = recipe;
        this.imageUrl = imageUrl;
        this.regDate = regDate;
    }

    // Getter & Setter
    public int getTableId() { return tableId; }
    public void setTableId(int tableId) { this.tableId = tableId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getFoodId() { return foodId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getKcal() { return kcal; }
    public void setKcal(int kcal) { this.kcal = kcal; }

    public double getProtein() { return protein; }
    public void setProtein(double protein) { this.protein = protein; }

    public double getCarb() { return carb; }
    public void setCarb(double carb) { this.carb = carb; }

    public double getFat() { return fat; }
    public void setFat(double fat) { this.fat = fat; }

    public String getRecipe() { return recipe; }
    public void setRecipe(String recipe) { this.recipe = recipe; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Date getRegDate() { return regDate; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }
}