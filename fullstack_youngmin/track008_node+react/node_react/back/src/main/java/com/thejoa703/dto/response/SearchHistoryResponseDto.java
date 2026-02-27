package com.thejoa703.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 검색 기록 응답 DTO
 * DB에 저장된 히스토리 내역을 사용자에게 보여줄 때 사용
 */
@Getter @Setter
public class SearchHistoryResponseDto {
    
    private Long id;            // 기록 고유 ID
    private String category;    // 검색했던 카테고리
    private String location;    // 검색했던 지역
    private String hashtag;     // 검색했던 해시태그 키워드
    private LocalDateTime searchedAt; // 검색한 시각
    
    // 필요 시 검색한 사용자의 ID 포함
    private Long userId;        
}