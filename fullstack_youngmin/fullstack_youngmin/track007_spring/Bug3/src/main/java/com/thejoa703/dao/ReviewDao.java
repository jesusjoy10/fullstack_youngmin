package com.thejoa703.dao;

import java.util.List;

import com.thejoa703.dto.ReviewDto;

public interface ReviewDao {

    // 레시피 ID로 리뷰 목록 조회
    List<ReviewDto> findByRecipeId(int recipeId);

    // 리뷰 등록
    int insertReview(ReviewDto dto);
}