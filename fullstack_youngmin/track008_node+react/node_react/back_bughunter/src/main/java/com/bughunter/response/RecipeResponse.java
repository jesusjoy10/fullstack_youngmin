package com.bughunter.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeResponse {
    private Long id;
    private String title;
    private String category;
    private String image;
}