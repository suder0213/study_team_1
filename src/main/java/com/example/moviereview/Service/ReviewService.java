package com.example.moviereview.Service;

import com.example.moviereview.Repository.MovieRepository;
import com.example.moviereview.Repository.ReviewRepository;
import com.example.moviereview.Repository.UserRepository;
import com.example.moviereview.dto.ReviewResponseDTO;
import com.example.moviereview.entity.Movie;
import com.example.moviereview.entity.Review;
import com.example.moviereview.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public Review createReview(Review review) {
        User user = userRepository.findById(review.getUser().getUserId()).orElseThrow();
        Movie movie = movieRepository.findById(review.getMovie().getMovieId()).orElseThrow();

        review.setUser(user);
        review.setMovie(movie);

        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<ReviewResponseDTO> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserUserId(userId).stream()
                .map(r -> new ReviewResponseDTO(
                        r.getReviewId(),
                        r.getRating(),
                        r.getComment(),
                        r.getCreatedAt()
                ))
                .toList();
    }


    public List<ReviewResponseDTO> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieMovieId(movieId).stream()
                .map(r -> new ReviewResponseDTO(
                        r.getReviewId(),
                        r.getRating(),
                        r.getComment(),
                        r.getCreatedAt()
                ))
                .toList();
    }

    public ReviewResponseDTO getReview(Long id) {
        return reviewRepository.findById(id)
                .map(r -> new ReviewResponseDTO(
                        r.getReviewId(),
                        r.getRating(),
                        r.getComment(),
                        r.getCreatedAt()
                ))
                .orElse(null);
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
