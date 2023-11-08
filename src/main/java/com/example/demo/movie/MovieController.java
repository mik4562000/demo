package com.example.demo.movie;

import com.example.demo.movie.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movie")
class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Movie> search() {
        return service.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie movies(@PathVariable int id) {
        return service.getMovie(id);
    }

    @PostMapping
    public Integer add(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }

}
