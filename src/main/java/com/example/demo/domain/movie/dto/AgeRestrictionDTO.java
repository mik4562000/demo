package com.example.demo.domain.movie.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AgeRestrictionDTO {
    private int Id;
    @Size(min = 2, max = 100)
    private String Name;
    @Min(0)
    @Max(21)
    private int Age;
}
