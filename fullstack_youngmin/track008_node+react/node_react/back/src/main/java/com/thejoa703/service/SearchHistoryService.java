package com.thejoa703.service;

import com.thejoa703.dto.request.SearchHistoryRequestDto;
import com.thejoa703.dto.response.SearchHistoryResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.entity.SearchHistory;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;
    private final AppUserRepository appUserRepository;

    @Transactional
    public List<Post> searchAndSave(Long userId, SearchHistoryRequestDto requestDto) {
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (isNotBlank(requestDto.getCategory()) || isNotBlank(requestDto.getLocation()) || isNotBlank(requestDto.getHashtag())) {
            SearchHistory history = new SearchHistory();
            history.setCategory(requestDto.getCategory());
            history.setLocation(requestDto.getLocation());
            history.setHashtag(requestDto.getHashtag());
            history.setUser(user);
            searchHistoryRepository.save(history);
        }

        List<Long> postIds = searchHistoryRepository.findPostIdsByFilters(
                requestDto.getCategory(), requestDto.getLocation(), requestDto.getHashtag());

        if (postIds == null || postIds.isEmpty()) return Collections.emptyList();

        return searchHistoryRepository.findPostsByIds(postIds);
    }

    public List<SearchHistoryResponseDto> getMyHistory(Long userId) {
        return searchHistoryRepository.findByUserIdOrderBySearchedAtDesc(userId).stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    // ⭐ 이미지에서 오류 나던 부분: 레포지토리에 메서드를 추가했으므로 이제 정상 작동합니다.
    @Transactional
    public void clearHistory(Long userId) {
        searchHistoryRepository.deleteAllByUserId(userId);
    }

    private SearchHistoryResponseDto toResponseDto(SearchHistory history) {
        SearchHistoryResponseDto dto = new SearchHistoryResponseDto();
        dto.setId(history.getId());
        dto.setCategory(history.getCategory());
        dto.setLocation(history.getLocation());
        dto.setHashtag(history.getHashtag());
        dto.setSearchedAt(history.getSearchedAt());
        dto.setUserId(history.getUser().getId());
        return dto;
    }

    private boolean isNotBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }
}