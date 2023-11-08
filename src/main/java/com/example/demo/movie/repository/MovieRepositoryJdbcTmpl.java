package com.example.demo.movie.repository;

import com.example.demo.movie.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
class MovieRepositoryJdbcTmpl implements IMovieRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    MovieRepositoryJdbcTmpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getMovieList() {

        String sql = """
                select movie_id, movie_name, release_year, country_name
                from movie
                """;

        return jdbcTemplate.query(sql, movieRowMapper);
    }

    private final RowMapper<Movie> movieRowMapper = (resultSet, rowNum) -> {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("movie_id"));
        movie.setMovieName(resultSet.getString("movie_name"));
        movie.setReleaseYear(resultSet.getInt("release_year"));
        movie.setCountryName(resultSet.getString("country_name"));
        return movie;
    };

    @Override
    public Movie getMovie(int id) {
        String sql = """
                select movie_id, movie_name, release_year, country_name
                                from movie
                                where movie_id = :p_movie_id
                """;
        Map<String, Integer> argMap = new HashMap<>();
        argMap.put("p_movie_id", id);
        return jdbcTemplate.queryForObject(sql, argMap, movieRowMapper);
    }

    @Override
    public Integer addMovie(Movie movie) {
        String sql = """
                insert into movie(movie_name, release_year, country_name)
                values (:p_movie_name, :p_release_year, :p_country_name)
                returning movie_id
                """;
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("p_movie_name", movie.getMovieName());
        argMap.put("p_release_year", movie.getReleaseYear());
        argMap.put("p_country_name", movie.getCountryName());
        return jdbcTemplate.queryForObject(sql, argMap, Integer.class);

    }

}
