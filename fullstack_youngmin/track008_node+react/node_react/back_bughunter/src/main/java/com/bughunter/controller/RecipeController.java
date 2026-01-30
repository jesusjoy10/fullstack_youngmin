package com.bughunter.controller;

import com.bughunter.domain.Recipe;
import com.bughunter.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recommend")
    public List<Recipe> recommend(@RequestParam("category") String category) {
        return recipeService.getRecipes(category);
    }
}