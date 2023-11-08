package com.example.demo.movie.repository;

import com.example.demo.movie.MovieSqlException;
import com.example.demo.movie.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Repository
class MovieRepository implements IMovieRepository {
    private static final String URL = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "10241024";

    @Override
    public List<Movie> getMovieList() {
        List<Movie> moviesList = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select movie_id, movie_name, release_year, country_name from movie")
        ) {

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("movie_id"));
                movie.setMovieName(resultSet.getString("movie_name"));
                movie.setReleaseYear(resultSet.getInt("release_year"));
                movie.setCountryName(resultSet.getString("country_name"));
                moviesList.add(movie);
            }

        } catch (SQLException e) {
            throw new MovieSqlException(e.getMessage());
        }
        return moviesList;
    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = new Movie();

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = conn.prepareStatement(
                        """
                                select movie_id, movie_name, release_year, country_name
                                from movie
                                where movie_id = ?
                                """
                )
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                movie.setId(resultSet.getInt("movie_id"));
                movie.setMovieName(resultSet.getString("movie_name"));
                movie.setReleaseYear(resultSet.getInt("release_year"));
                movie.setCountryName(resultSet.getString("country_name"));
            }

        } catch (SQLException e) {
            throw new MovieSqlException(e.getMessage());
        }
        return movie;
    }

    @Override
    public Integer addMovie(Movie movie) {
        int newMovieId = -1;

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = conn.prepareStatement(
                        "insert into movie(movie_name, release_year, country_name) " +
                                "values (?, ?, ?) " +
                                "returning movie_id")
        ) {

            statement.setString(1, movie.getMovieName());
            statement.setInt(2, movie.getReleaseYear());
            statement.setString(3, movie.getCountryName());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                newMovieId = resultSet.getInt("movie_id");
            }

        } catch (SQLException e) {
            throw new MovieSqlException(e.getMessage());
        }
        return newMovieId;
    }

}
