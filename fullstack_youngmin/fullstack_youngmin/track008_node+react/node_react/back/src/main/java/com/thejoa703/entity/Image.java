package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name= "IMAGES")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq", sequenceName = "IMAGE_SEQ", allocationSize = 1)
    private Long id; // PK
    
    @ManyToOne //한 글은 여러 이미지를 갖는다
    @JoinColumn(name = "POST_ID", nullable = false) // POST_ID라는 외래키(FK), post엔티티의 pk(id)참조
    private Post post; // 외래키 필드
    
    
    @Column(length = 200,  nullable = false)
    private String src; // VARCHAR2(200 CHAR)
    
    
   
}