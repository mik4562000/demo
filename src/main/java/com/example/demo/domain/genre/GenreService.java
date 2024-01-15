package com.example.demo.domain.genre;

import com.example.demo.domain.genre.dto.GenreDTO;
import com.example.demo.domain.genre.model.Genre;
import com.example.demo.domain.genre.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
class GenreService {
    private final GenreRepository genreRepository;
    private final MessageSource translationSource;


    private String localize(String Key, String defaultValue) {
        return translationSource.getMessage(Key, null, defaultValue, LocaleContextHolder.getLocale());
    }
    public List<GenreDTO> getGenreList() {
        List<Genre> genreList = genreRepository.findAll();
        List<GenreDTO> genreDTOList = genreList.stream()
                .map(GenreDTO::new)
                .map(genreDTO -> {
                    String translatedName = localize(format("genre.%s",genreDTO.getKey()) , genreDTO.getName());
                    return new GenreDTO(genreDTO.getId(), genreDTO.getKey(), translatedName);
                })
                .toList();
        return genreDTOList;
    }
}
