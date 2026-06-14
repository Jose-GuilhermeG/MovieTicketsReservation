package io.github.CineTickets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MovieDTO(
        Integer id,
        @NotBlank(message = "Title can't be blank")
        String title,
        @NotBlank(message = "synopsis can't be blank")
        String synopsis,
        @NotNull(message = "Duration can't be null")
        Integer durationMinutes,
        String ageRating,
        @NotNull(message = "Release can't be null")
        LocalDate releaseDate
) {}
