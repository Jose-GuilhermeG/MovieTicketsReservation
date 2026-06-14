package io.github.CineTickets.controllers;

import io.github.CineTickets.dto.MovieDTO;
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
    public ResponseEntity<Void> createMovie(@Valid @RequestBody MovieDTO data){
        service.createMovie(mapper.toEntity(data));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> ListMovies(Pageable pageable , @RequestParam(required = false) String title){
        List<MovieDTO> data = service.listMovies(pageable , title).map(movie -> mapper.toDTO(movie)).toList();

        return ResponseEntity.ok(data);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> movieDetail(@PathVariable Integer id){
        return ResponseEntity.ok(mapper.toDTO(service.movieDetail(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id){
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}
