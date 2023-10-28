package com.example.demo.services;

import com.example.demo.models.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public Movie[] getMovieList() {
        return new Movie[] {
                new Movie("The Fall of the House of Usher", 2023, "USA"),
                new Movie("Killers of the Flower Moon", 2023, "USA"),
                new Movie("Loki", 2021, "USA"),
        };
    }

    public Movie getMovie(int id) {
        return new Movie("The Fall of the House of Usher", 2023, "USA");
    }

    public Movie addMovie(Movie newMovie) {
        return newMovie;
    }
}
