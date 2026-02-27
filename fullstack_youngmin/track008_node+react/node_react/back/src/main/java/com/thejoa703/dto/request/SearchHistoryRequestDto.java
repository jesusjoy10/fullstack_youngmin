package com.thejoa703.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 맛집 검색 요청 DTO
 * 사용자가 선택한 검색 조건(카테고리, 지역, 해시태그)을 전달받음
 */
@Getter @Setter
public class SearchHistoryRequestDto {
    
    // 카테고리: 한식, 중식, 일식, 양식 등
    private String category;    
    
    // 지역: 인천 부평구, 서울 강남구 등 (드롭다운 선택 값)
    private String location;    
    
    // 해시태그: #가성비, #친절 등 (검색어 입력)
    private String hashtag;     
    
    
}