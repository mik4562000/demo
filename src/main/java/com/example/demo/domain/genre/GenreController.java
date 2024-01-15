package com.example.demo.domain.genre;

import com.example.demo.domain.genre.dto.GenreDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.lang.String.*;

@RestController()
@RequestMapping("/genre")
class GenreController {


    private final GenreService service;
    private final MessageSource translationSource;

    public GenreController(GenreService service, MessageSource translationSource) {
        this.service = service;
        this.translationSource = translationSource;
    }

    private String localize(String Key, String defaultValue) {
        return translationSource.getMessage(Key, null, defaultValue, LocaleContextHolder.getLocale());
    }

    @GetMapping("/search")
    public List<GenreDTO> search() {

        //ResourceBundle bundle = ResourceBundle.getBundle("translations", LocaleContextHolder.getLocale());

        List<GenreDTO> genreList = service.getGenreList();
        //AAAA лучше в сервис
        return genreList.stream()
                .map(genre -> {
                    String translatedName = localize(format("genre.%s",genre.getKey()) , genre.getName());
                    return new GenreDTO(genre.getId(), genre.getKey(), translatedName);
                })
                .toList();


    }

}
