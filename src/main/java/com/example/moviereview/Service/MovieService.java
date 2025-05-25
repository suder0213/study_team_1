package com.example.moviereview.Service;

import com.example.moviereview.Repository.MovieRepository;
import com.example.moviereview.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie update(Long id, Movie updated) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) return null;

        movie.setTitle(updated.getTitle());
        movie.setGenre(updated.getGenre());
        movie.setReleaseYear(updated.getReleaseYear());
        return movieRepository.save(movie);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
