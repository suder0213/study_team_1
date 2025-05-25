package com.example.moviereview.Service;

import com.example.moviereview.Repository.ReviewRepository;
import com.example.moviereview.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserUserId(userId);
    }

    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieMovieId(movieId);
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, Review updated) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) return null;

        review.setRating(updated.getRating());
        review.setComment(updated.getComment());
        return reviewRepository.save(review);
    }
}
