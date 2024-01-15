package com.example.demo.domain.genre.dto;

import com.example.demo.domain.genre.model.Genre;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {
    private int Id;
    @Size(min = 2, max = 100)
    private String Name;
    @Size(min = 2, max = 5)
    private String Key;

    public GenreDTO(Genre genre) {
        this.Id = genre.getId();
        this.Name = genre.getName();
        this.Key = genre.getKey();
    }

}
