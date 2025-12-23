package com.thejoa703.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.ReviewDao;
import com.thejoa703.dto.ReviewDto;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<ReviewDto> getReviewsByRecipeId(int recipeId) {
        return reviewDao.findByRecipeId(recipeId);
    }

    @Override
    public int writeReview(ReviewDto dto) {
        return reviewDao.insertReview(dto);
    }
}
