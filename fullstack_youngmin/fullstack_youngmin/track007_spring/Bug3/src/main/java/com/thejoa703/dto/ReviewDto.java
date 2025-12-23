package com.thejoa703.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int reviewId;
    private int recipeId;
    private int rating;
    private String commentText;
}