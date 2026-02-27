package com.bughunter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.bughunter.domain.Recipe; // 엔티티 임포트

@Mapper
public interface RecipeMapper {
    // 추천 검색
    List<Recipe> findRecommended(@Param("categoryName") String categoryName, 
                                 @Param("difficulty") String difficulty, 
                                 @Param("maxTime") Integer maxTime);

    // 카테고리 검색
    List<Recipe> findByCategory(@Param("category") String category);
}