package io.github.CineTickets.mappers;

import io.github.CineTickets.dto.MovieDTO;
import io.github.CineTickets.models.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDTO(Movie movie);
    Movie toEntity(MovieDTO dto);
}
