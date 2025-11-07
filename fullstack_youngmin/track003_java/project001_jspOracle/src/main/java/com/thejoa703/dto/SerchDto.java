package com.thejoa703.dto;

import java.time.LocalDateTime;

public class SerchDto {
	private int tableId ;
	private int id;
	private int foodId;
	private String type;
	private String category;     // 음식 대분류 (한식, 양식 등)
    private String kind;         // 음식 종류 (육류, 해산물 등)
    private String method;       // 조리 방식 (볶음, 구이 등)
	private String feedback;
	private LocalDateTime createdAt;
	public SerchDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SerchDto(int tableId , int id, int foodId, String type,String category, String kind, String method, String feedback, LocalDateTime createdAt) {
		super();
		this.tableId  = tableId ;
		this.id = id;
		this.foodId = foodId;
		this.type = type;
		this.category = category;
		this.kind = kind;
		this.method = method;
		this.feedback = feedback;
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "SerchDto [tableId =" + tableId  + ", id=" + id + ", foodId=" + foodId + ", type=" + type + ","
				+ " \"category='\" + category + '\\'' +\r\n"
				+ "            \", kind='\" + kind + '\\'' +\r\n"
				+ "            \", method='\" + method + '\\'' +\r\n"
				+ " feedback="
				+ feedback + ", createdAt=" + createdAt + "]";
	}
	public int getTableId() {
		return tableId ;
	}
	public void setTableId(int tableId) {
		this.tableId  = tableId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getCategory() {
	    return category;
	}
	public void setCategory(String category) {
	    this.category = category;
	}

	public String getKind() {
	    return kind;
	}
	public void setKind(String kind) {
	    this.kind = kind;
	}

	public String getMethod() {
	    return method;
	}
	public void setMethod(String method) {
	    this.method = method;
	}

	
	
}


/*/*CREATE TABLE RECOMMEND_TB (
    recId NUMBER(8) PRIMARY KEY,        -- 추천 고유번호  
    id VARCHAR2(30) NOT NULL,       -- 사용자 ID
    foodId NUMBER(6) ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦.
    type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반)
    feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)   
    createdAt DATE DEFAULT SYSDATE,      -- 추천 일시  
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)        
);*/