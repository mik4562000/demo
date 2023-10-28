package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/movie")
public class MovieController {

    MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public Movie[] search() {
        return service.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie movies(@PathVariable int id) {
        return service.getMovie(id);
    }

    @PostMapping
    public Movie newMovie(@RequestBody Movie newMovie) {
        return service.addMovie(newMovie);
    }

}
