package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "SEARCH_HISTORY")
@Getter @Setter
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "search_history_seq")
    @SequenceGenerator(name = "search_history_seq", sequenceName = "SEARCH_HISTORY_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 50)
    private String category;  // 한식, 중식 등

    @Column(length = 100)
    private String location;  // 지역

    @Column(length = 100)
    private String hashtag;   // 해시태그 검색어

    @Column(nullable = false)
    private LocalDateTime searchedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_USER_ID", nullable = false)
    private AppUser user;

    @PrePersist
    void onCreate() {
        this.searchedAt = LocalDateTime.now();
    }
}