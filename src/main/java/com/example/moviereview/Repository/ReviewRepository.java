package com.example.moviereview.Repository;

import com.example.moviereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserUserId(Long userId);
    List<Review> findByMovieMovieId(Long movieId);
}
