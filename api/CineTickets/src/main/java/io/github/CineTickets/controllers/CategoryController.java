package io.github.CineTickets.controllers;

import io.github.CineTickets.core.reponses.ApiResponse;
import io.github.CineTickets.dto.categoriesDto.RequestCategoryDTO;
import io.github.CineTickets.dto.categoriesDto.ResponseCategoryDTO;
import io.github.CineTickets.mappers.CategoryMapper;
import io.github.CineTickets.models.Category;
import io.github.CineTickets.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("categories/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDTO>> listCategory(Pageable pageable , @RequestParam(required = false) String name){
        List<ResponseCategoryDTO> data = service.listCategories(pageable , name)
                .map(category -> mapper.toDTO(category))
                .toList();
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCategory(@Valid @RequestBody RequestCategoryDTO data){
        Category category = service.createCategory(mapper.toEntity(data));
        URI instanceDetail = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(instanceDetail).body(new ApiResponse("category created"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> updateCategory(@PathVariable int id , @Valid @RequestBody RequestCategoryDTO data){
        service.updateCategory(id,mapper.toEntity(data));
        return ResponseEntity.ok().body(new ApiResponse<>("category updated"));
    }
}
