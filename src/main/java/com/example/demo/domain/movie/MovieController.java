package com.example.demo.domain.movie;

import com.example.demo.domain.movie.dto.MovieDTO;
import com.example.demo.domain.movie.model.Movie;
import com.example.demo.exception.ValidationException;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movie")
class MovieController {


    private final MovieService service;

    @Autowired
    @Qualifier("movieValidator") // spring validator
    private Validator movieValidator;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Movie> search(@RequestParam(required = false, defaultValue = "") String genre) {
        List<Movie> movieList = service.getMovieList(genre);
        return movieList;
    }

    @GetMapping("/searchbyage")
    public List<Movie> searchByAge(@RequestParam(required = false, defaultValue = "") int age) {
        List<Movie> movieList = service.findByAge(age);
        return movieList;
    }

    @GetMapping("/{id}")
    public Movie movies(@PathVariable int id) {
        return service.getMovie(id);
    }

    @PostMapping
    public int add(@Valid @RequestBody MovieDTO movie, BindingResult bindingResult) {
        movieValidator.validate(movie, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().toString());
        }
        return service.addMovie(movie);
    }

}
