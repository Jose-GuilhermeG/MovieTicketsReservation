package io.github.CineTickets.controllers;

import io.github.CineTickets.dto.moviesDto.CreateMovieDTO;
import io.github.CineTickets.dto.moviesDto.DetailMovieDTO;
import io.github.CineTickets.dto.moviesDto.ListMovieDTO;
import io.github.CineTickets.mappers.MovieMapper;
import io.github.CineTickets.services.MovieServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieControllers {

    private final MovieServices service;
    private final MovieMapper mapper;

    @PostMapping
    public ResponseEntity<Void> createMovie(@Valid @RequestBody CreateMovieDTO data){
        List<Integer> categoriesIds = data.categoriesId();
        service.createMovie(mapper.toEntity(data),categoriesIds);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ListMovieDTO>> ListMovies(
            Pageable pageable ,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) List<String> categories
    ){
        List<ListMovieDTO> data = service.listMovies(pageable , title , categories).map(movie -> mapper.toListDTO(movie)).toList();

        return ResponseEntity.ok(data);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailMovieDTO> movieDetail(@PathVariable Integer id){
        return ResponseEntity.ok(mapper.toDetailDTO(service.movieDetail(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id){
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
