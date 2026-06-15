package io.github.CineTickets.dto.moviesDto;

import io.github.CineTickets.dto.categoriesDto.ResponseCategoryDTO;

import java.time.LocalDate;
import java.util.List;


public record DetailMovieDTO(
        int id,
        String title,
        Integer durationMinutes,
        String ageRating,
        String synopsis,
        LocalDate releaseDate,
        List<ResponseCategoryDTO> categories
        ) {
}
