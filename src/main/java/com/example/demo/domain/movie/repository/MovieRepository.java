package com.example.demo.domain.movie.repository;

import com.example.demo.domain.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m join fetch m.genres g join fetch m.Country join fetch m.AgeRestriction where upper(g.Name) like %:genreName%")
    List<Movie> findByGenreName(@Param("genreName") String genreName);

    @Query(
            value = "select * from movie m join parents_guide pg on m.pg_id = pg.pg_id where pg.pg_age >= :age",
            nativeQuery = true
    )
    List<Movie> findByAge(@Param("age") int age);

    //Query
    //Native query
    //GetByField
    // n+1 problem
    // @Transactional

}
