package com.example.demo.domain.movie;

import com.example.demo.domain.movie.dto.MovieDTO;
import com.example.demo.domain.movie.model.Movie;
import com.example.demo.exception.MovieException;
import com.example.demo.domain.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getMovieList(String genreName) {
        try {
            List<Movie> movieList = movieRepository.findByGenreName(genreName.toUpperCase());
            return movieList;
        } catch (InvalidDataAccessResourceUsageException e) {
            throw new MovieException(e);
        } catch (RuntimeException e) {
            throw new MovieException(e);
        }
    }

    public List<Movie> findByAge(int age) {
        return movieRepository.findByAge(age);
    }
    public Movie getMovie(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public int addMovie(MovieDTO movie) {
        Movie savingMovie = new Movie();
        savingMovie.setMovieName(movie.getMovieName());
        savingMovie.setReleaseYear(movie.getReleaseYear());

        Movie newMovie = movieRepository.save(savingMovie);
        return newMovie.getId();
    }
}
