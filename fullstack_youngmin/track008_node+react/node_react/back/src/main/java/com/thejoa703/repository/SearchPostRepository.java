package com.thejoa703.repository;
import com.thejoa703.entity.Post;
import com.thejoa703.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SearchPostRepository extends JpaRepository<Post, Long> {
    // ---------------- 게시글 검색 ----------------

    // JPA 메서드로 단일 조건 검색
    List<Post> findByCategory(String category);

    List<Post> findByDescriptionContaining(String location);

    List<Post> findByHashtags_NameContaining(String hashtag);

    // Oracle 11 특수 함수가 필요한 교집합 검색만 Native Query
    @Query(value = "SELECT DISTINCT p.* FROM POSTS p " +
                   "LEFT JOIN POST_HASHTAG ph ON p.ID = ph.POST_ID " +
                   "LEFT JOIN HASHTAGS h ON ph.HASHTAG_ID = h.ID " +
                   "WHERE (:category IS NULL OR p.CATEGORY = :category) " +
                   "AND (:location IS NULL OR REGEXP_LIKE(p.DESCRIPTION, :location)) " +
                   "AND (:hashtag IS NULL OR h.NAME LIKE '%' || :hashtag || '%') " +
                   "AND p.DELETED = 0 " +
                   "ORDER BY p.CREATED_AT DESC",
           nativeQuery = true)
    List<Post> findByCategoryLocationHashtag(@Param("category") String category,
                                             @Param("location") String location,
                                             @Param("hashtag") String hashtag);
}




//@Repository
//public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
//
//    // 1. 특정 유저의 검색 기록 조회
//    List<SearchHistory> findByUserIdOrderBySearchedAtDesc(Long userId);
//
//    // 2. 맛집 통합 검색 (Oracle 11, CLOB 호환) 
//    @Query(value = "SELECT DISTINCT p.* FROM POSTS p " +
//            "LEFT JOIN POST_HASHTAG ph ON p.ID = ph.POST_ID " +
//            "LEFT JOIN HASHTAGS h ON ph.HASHTAG_ID = h.ID " +
//            "WHERE (:category IS NULL OR p.CATEGORY = :category) " +
//            "  AND (:location IS NULL OR REGEXP_LIKE(p.INGREDIENTS, :location)) " +
//            "  AND (:hashtag IS NULL OR h.NAME LIKE '%' || :hashtag || '%') " +
//            "  AND p.DELETED = 0 " +
//            "ORDER BY p.CREATED_AT DESC", nativeQuery = true)
//    List<Post> findStoresByFilters(
//            @Param("category") String category,
//            @Param("location") String location,
//            @Param("hashtag") String hashtag
//    );

