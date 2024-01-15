package com.example.demo.domain.movie.model;

import com.example.demo.domain.genre.model.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie", schema = "demo")
public class Movie {
    @Id
    @Column(name="movie_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

    //@Column(name="movie_name")
    private String MovieName;
    @Column(name="release_year")
    private int ReleaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country Country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_id", referencedColumnName = "pg_id")
    private AgeRestriction AgeRestriction;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return Id == movie.Id;
    }

    @Override
    public int hashCode() {
        return Id;
    }
}
