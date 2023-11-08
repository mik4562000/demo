package com.example.demo.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int Id;
    private String MovieName;
    private int ReleaseYear;
    private String CountryName;

    public Movie(Movie movie) {
        this.Id = movie.Id;
        this.MovieName = movie.MovieName;
        this.ReleaseYear = movie.ReleaseYear;
        this.CountryName = movie.CountryName;
    }

}
