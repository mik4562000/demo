package com.example.demo.movie;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private IMovieRepository repository;
    public MovieService(IMovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getMovieList() {
        return repository.getMovieList();
    }

    public Movie getMovie(int id) {
        return  repository.getMovie(id);
    }

    public Integer addMovie(Movie movie) {
        return repository.addMovie(movie);
    }
}
