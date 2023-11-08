package com.example.demo.movie.repository;

import com.example.demo.movie.model.Movie;

import java.util.List;

public interface IMovieRepository {
    List<Movie> getMovieList();

    Movie getMovie(int id);

    Integer addMovie(Movie movie);
}
