package com.example.demo.domain.genre;

import com.example.demo.domain.genre.dto.GenreDTO;
import com.example.demo.domain.genre.model.Genre;
import com.example.demo.domain.genre.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class GenreService {
    private final GenreRepository genreRepository;

    public List<GenreDTO> getGenreList() {
        List<Genre> genreList = genreRepository.findAll();
        List<GenreDTO> genreDTOList = genreList.stream()
                .map(GenreDTO::new)
                .collect(Collectors.toList());
        return genreDTOList;
    }
}
