package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 게시글 엔티티
 */
@Entity
@Table(name= "FOLLOWS")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
    @SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
    private Long id; // PK
      
    @Column(nullable = false , name="CREATED_AT")
    private LocalDateTime createdAt; // 생성일시
    
    @PrePersist
    void onCreate() {
       this.createdAt = LocalDateTime.now();
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FOLLOWER_ID", nullable =false)
    private AppUser follower;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FOLLOWEE_ID", nullable =false)
    private AppUser followee;
    
    public Follow(AppUser follower, AppUser followee) {
    	super();
    	this.follower = follower;
    	this.followee = followee;
    }
}