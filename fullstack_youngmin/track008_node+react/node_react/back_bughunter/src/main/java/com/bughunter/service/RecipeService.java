package com.bughunter.service;

import com.bughunter.domain.Recipe;
import com.bughunter.mapper.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeMapper recipeMapper;

    public List<Recipe> getRecipes(String category) {
        return recipeMapper.findByCategory(category);
    }
}