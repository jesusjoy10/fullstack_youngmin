package com.thejoa703.service;

import java.util.List;

import com.thejoa703.dto.ReviewDto;

public interface ReviewService {

    // 리뷰 목록 조회
    List<ReviewDto> getReviewsByRecipeId(int recipeId);

    // 리뷰 등록
    int writeReview(ReviewDto dto);
}
