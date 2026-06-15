package io.github.CineTickets.dto.moviesDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ListMovieDTO(
        Integer id,
        @NotBlank(message = "Title can't be blank")
        String title,
        @NotNull(message = "Duration can't be null")
        Integer durationMinutes,
        String ageRating
) {}
