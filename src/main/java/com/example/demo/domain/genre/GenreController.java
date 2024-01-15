package com.example.demo.domain.genre;

import com.example.demo.domain.genre.dto.GenreDTO;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/genre")
class GenreController {

    private final GenreService service;

    public GenreController(GenreService service, MessageSource translationSource) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<GenreDTO> search() {
        return service.getGenreList();
    }

}
