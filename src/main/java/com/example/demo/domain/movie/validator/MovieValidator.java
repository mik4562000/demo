package com.example.demo.domain.movie.validator;

import com.example.demo.domain.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MovieDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "MovieName", "MovieName.required", "Title cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "ReleaseYear", "ReleaseYear.required", "Release year cannot be empty");
        MovieDTO movie = (MovieDTO) target;
        if (movie.getReleaseYear() < 0) {
            errors.rejectValue("ReleaseYear", "ReleaseYear.negative.value", "Release year should be positive number");
        } else if (movie.getReleaseYear() > 2100) {
            errors.rejectValue("ReleaseYear", "ReleaseYear.too.large", "Release year should be before 3000");
        }
    }
}
