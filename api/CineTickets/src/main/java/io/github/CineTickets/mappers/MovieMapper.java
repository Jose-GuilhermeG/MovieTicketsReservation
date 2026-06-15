package io.github.CineTickets.mappers;

import io.github.CineTickets.dto.categoriesDto.ResponseCategoryDTO;
import io.github.CineTickets.dto.moviesDto.CreateMovieDTO;
import io.github.CineTickets.dto.moviesDto.DetailMovieDTO;
import io.github.CineTickets.dto.moviesDto.ListMovieDTO;
import io.github.CineTickets.models.Category;
import io.github.CineTickets.models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    ListMovieDTO toListDTO(Movie movie);

    @Mapping(target = "categories",source = "categories")
    DetailMovieDTO toDetailDTO(Movie movie);

    Movie toEntity(ListMovieDTO dto);

    @Mapping(target = "categories",ignore = true)
    Movie toEntity(CreateMovieDTO dto);
}
