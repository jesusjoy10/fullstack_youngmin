package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import com.thejoa703.dto.request.SearchHistoryRequestDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.SearchHistoryRepository;
import com.thejoa703.service.SearchHistoryService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(SearchHistoryService.class) // 중요: 테스트 환경에 서비스를 수동으로 등록
class BackApplicationTests1_Repository {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private TestEntityManager entityManager; // 타입 상관없이 객체를 저장할 수 있는 도구

    @Test
    @DisplayName("맛집 검색 시 2단계 조회를 통해 CLOB 에러 없이 데이터를 가져온다")
    void searchAndSaveSuccessTest() {
        // [given]
        // 1. 유저 생성 및 저장
        AppUser testUser = AppUser.builder()
                .email("test@thejoa.com")
                .nickname("테스터")
                .provider("local")
                .build();
        entityManager.persist(testUser);

        // 2. 검색 대상 맛집(Post) 생성 및 저장
        // 주의: searchHistoryRepository.save(new Post())는 타입이 달라 불가능하므로 매니저를 사용합니다.
        Post post = new Post();
        post.setTitle("인천 맛집 김치찌개");
        post.setCategory("한식");
        post.setIngredients("인천 남동구, 김치찌개, 고기"); 
        post.setUser(testUser); 
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setDeleted(false);
        
        entityManager.persist(post); // 엔티티 매니저로 Post 저장
        entityManager.flush();
        entityManager.clear();

        // 3. 검색 요청 데이터
        SearchHistoryRequestDto requestDto = new SearchHistoryRequestDto();
        requestDto.setCategory("한식");
        requestDto.setLocation("인천");

        // [when]
        // 서비스의 2단계 조회 로직 실행 (1.ID목록조회 -> 2.실물객체조회)
        List<Post> results = searchHistoryService.searchAndSave(testUser.getId(), requestDto);

        // [then]
        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getTitle()).contains("김치찌개");
        
        // 검색 히스토리가 DB에 남았는지 확인
        var history = searchHistoryRepository.findByUserIdOrderBySearchedAtDesc(testUser.getId());
        assertThat(history).hasSize(1);
    }
}