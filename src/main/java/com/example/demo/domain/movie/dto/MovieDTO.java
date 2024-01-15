package com.example.demo.domain.movie.dto;

import com.example.demo.domain.genre.dto.GenreDTO;
import com.example.demo.validation.ModernDaysYearConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class MovieDTO {

    private int Id;
    //@Size(min = 2, max = 100)
    private String MovieName;
    @ModernDaysYearConstraint
    private int ReleaseYear;
    private CountryDTO Country;
    private AgeRestrictionDTO AgeRestriction;
    Set<GenreDTO> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDTO movie = (MovieDTO) o;

        return Id == movie.Id;
    }

    @Override
    public int hashCode() {
        return Id;
    }
}
