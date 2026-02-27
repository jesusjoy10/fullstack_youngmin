package com.thejoa703.repository;

import com.thejoa703.entity.Post;
import com.thejoa703.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {

    // 1. 히스토리 조회
    List<SearchHistory> findByUserIdOrderBySearchedAtDesc(Long userId);

    // 2. 히스토리 삭제 
    @Modifying
    @Query("DELETE FROM SearchHistory s WHERE s.user.id = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);

    // 3. 2단계 조회용 ID 추출 (Oracle CLOB 에러 회피)
    @Query("SELECT DISTINCT p.id FROM Post p " +
           "LEFT JOIN p.hashtags h " +
           "WHERE (:category IS NULL OR p.category = :category) " +
           "  AND (:location IS NULL OR function('DBMS_LOB.INSTR', p.ingredients, :location) > 0) " +
           "  AND (:hashtag IS NULL OR h.name LIKE %:hashtag%) " +
           "  AND p.deleted = false")
    List<Long> findPostIdsByFilters(
            @Param("category") String category, 
            @Param("location") String location, 
            @Param("hashtag") String hashtag
    );

    // 4. ID 기반 실물 Post 조회
    @Query("SELECT p FROM Post p WHERE p.id IN :ids ORDER BY p.createdAt DESC")
    List<Post> findPostsByIds(@Param("ids") List<Long> ids);
}