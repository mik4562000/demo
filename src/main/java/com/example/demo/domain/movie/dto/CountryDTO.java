package com.example.demo.domain.movie.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CountryDTO {
    private int Id;
    @Size(min = 2, max = 100)
    private String Name;
}
