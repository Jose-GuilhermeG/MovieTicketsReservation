package io.github.CineTickets.dto.categoriesDto;

import jakarta.validation.constraints.NotBlank;

public record RequestCategoryDTO(
        @NotBlank(message = "name can't be blank")
        String name ,
        String description
) {}
