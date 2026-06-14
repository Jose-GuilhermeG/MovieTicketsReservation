package io.github.CineTickets.mappers;

import io.github.CineTickets.dto.categoriesDto.RequestCategoryDTO;
import io.github.CineTickets.dto.categoriesDto.ResponseCategoryDTO;
import io.github.CineTickets.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper{
    Category toEntity(RequestCategoryDTO dto);
    ResponseCategoryDTO toDTO(Category entity);
}
