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
@Table(name= "RETWEETS")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Retweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retweet_seq")
    @SequenceGenerator(name = "retweet_seq", sequenceName = "RETWEET_SEQ", allocationSize = 1)
    private Long id; // PK
      
    @Column(nullable = false , name="CREATED_AT")
    private LocalDateTime createdAt; // 리트윗시점
    
    @PrePersist
    void onCreate() {
       this.createdAt = LocalDateTime.now();
    }
    
    @ManyToOne
    @JoinColumn(  name="APP_USER_ID" , nullable=false )
    private AppUser user;  // 리트윗한 사람
    
    @ManyToOne 
    @JoinColumn(  name="ORIGINAL_POST_ID" , nullable=false )
    private Post originalPost; //원본 게세글

	public Retweet(AppUser user, Post originalPost) {
		super();
		this.user = user;
		this.originalPost = originalPost;
	}
    
   
}