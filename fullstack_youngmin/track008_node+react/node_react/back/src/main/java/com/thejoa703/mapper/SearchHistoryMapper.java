package com.thejoa703.mapper; 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.thejoa703.entity.Post;

@Mapper
public interface SearchHistoryMapper {

    List<Post> findStoresByFilters(
            @Param("category") String category,
            @Param("location") String location,
            @Param("hashtag") String hashtag
    );

}
