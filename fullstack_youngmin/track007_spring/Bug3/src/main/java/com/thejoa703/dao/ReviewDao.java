package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.ReviewDto;

@Mapper
public interface ReviewDao {

    // 레시피 ID로 리뷰 목록 조회
    List<ReviewDto> findByRecipeId(int recipeId);

    // 리뷰 등록
    int insertReview(ReviewDto dto);
}