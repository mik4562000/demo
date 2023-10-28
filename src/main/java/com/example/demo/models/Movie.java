package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class Movie {
    private String MovieName;
    private int ReleaseYear;
    private String CountryName;

    public Movie(String MovieName, int ReleaseYear, String CountryName) {
        this.MovieName = MovieName;
        this.ReleaseYear = ReleaseYear;
        this.CountryName = CountryName;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
