package org.personal.thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  // 영화/드라마 제목
    private String content;  // 리뷰 내용
    private String author;  // 작성자
    private LocalDate createdDate;  // 작성 날짜
    private int rating;  // 별점 (1~5)
}
