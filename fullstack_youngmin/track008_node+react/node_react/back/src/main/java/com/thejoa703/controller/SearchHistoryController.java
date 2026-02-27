package com.thejoa703.controller;

import com.thejoa703.dto.request.SearchHistoryRequestDto;
import com.thejoa703.dto.response.SearchHistoryResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.oauth2.CustomOAuth2User;
import com.thejoa703.service.SearchHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Search & History", description = "맛집 검색 및 사용자 검색 기록 관리 API")
@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    @Operation(summary = "맛집 통합 검색 및 기록 저장", 
               description = "카테고리, 위치, 해시태그를 이용해 맛집을 검색하고 해당 검색 조건을 히스토리에 저장합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "검색 성공",
            content = @Content(schema = @Schema(implementation = Post.class))),
        @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자 (로그인 필요)", content = @Content),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류 (DB CLOB 처리 오류 등)", content = @Content)
    })
    @PostMapping("/restaurants")
    public ResponseEntity<List<Post>> search(@AuthenticationPrincipal CustomOAuth2User user, 
                                             @RequestBody SearchHistoryRequestDto dto) {
        // user.getId()를 통해 현재 로그인한 사용자 정보를 서비스로 전달
        return ResponseEntity.ok(searchHistoryService.searchAndSave(user.getId(), dto));
    }

    @Operation(summary = "내 검색 기록 조회", 
               description = "현재 로그인한 사용자의 최근 검색 기록을 최신순으로 가져옵니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    @GetMapping("/history/me")
    public ResponseEntity<List<SearchHistoryResponseDto>> getHistory(@AuthenticationPrincipal CustomOAuth2User user) {
        return ResponseEntity.ok(searchHistoryService.getMyHistory(user.getId()));
    }

    @Operation(summary = "내 검색 기록 전체 삭제", 
               description = "사용자의 모든 검색 히스토리를 데이터베이스에서 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "삭제 성공 (반환 데이터 없음)")
    @DeleteMapping("/history")
    public ResponseEntity<Void> clearHistory(@AuthenticationPrincipal CustomOAuth2User user) {
        searchHistoryService.clearHistory(user.getId());
        return ResponseEntity.noContent().build();
    }
}