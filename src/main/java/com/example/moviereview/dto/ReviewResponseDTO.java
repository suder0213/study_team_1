package com.example.moviereview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewResponseDTO {
    private Long reviewId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}