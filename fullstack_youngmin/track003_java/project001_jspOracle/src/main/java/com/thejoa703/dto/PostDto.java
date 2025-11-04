package com.thejoa703.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class PostDto{
	private int recId;
	private String Id;
	private int foodId;
	private String type;
	private String feedback;
	private LocalDateTime createdAt;
	public int getRecId() {
		return recId;
	}
	@Override
	public String toString() {
		return "PostDto [recId=" + recId + ", userId=" + Id + ", foodid=" + foodId + ", type=" + type + ", feedback="
				+ feedback + ", createdAt=" + createdAt + "]";
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto(int recId, String id, int foodId, String type, String feedback, LocalDateTime createdAt) {
		super();
		this.recId = recId;
		Id = id;
		this.foodId = foodId;
		this.type = type;
		this.feedback = feedback;
		this.createdAt = createdAt;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public void setRecId(int recId) {
		this.recId = recId;
	}
	
	
				
}


/*CREATE TABLE RECOMMEND_TB (
    recId NUMBER(8) PRIMARY KEY,        -- 추천 고유번호  
    id VARCHAR2(30) NOT NULL,       -- 사용자 ID
    foodId NUMBER(6) ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦.
    type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반)
    feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)   
    createdAt DATE DEFAULT SYSDATE,      -- 추천 일시  
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)        
);*/