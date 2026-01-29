package com.bughunter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bughunter.domain.Recipe;
@Mapper
public interface RecipeMapper {
    // SQL문은 나중에 XML 파일에 작성할 거예요.
    List<Recipe> findByCategory(String category);
}