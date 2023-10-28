package com.example.demo.models;


public class Movie1111 {
    private String MovieName;
    private int ReleaseYear;
    private String CountryName;

    public Movie1111(String MovieName, int ReleaseYear, String CountryName) {
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
