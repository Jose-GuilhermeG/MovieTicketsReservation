package io.github.CineTickets.services;

import io.github.CineTickets.exceptions.AlreadyExistsException;
import io.github.CineTickets.exceptions.NotExistsException;
import io.github.CineTickets.models.Category;
import io.github.CineTickets.repositories.CategoryRepository;
import io.github.CineTickets.specifications.CategorySpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category createCategory(Category data){
        if(repository.existsByName(data.getName())) throw new AlreadyExistsException("");
        return repository.save(data);
    }

    public Page<Category> listCategories(Pageable pageable , String name){
        Specification<Category> spec = Specification.where(CategorySpecifications.filterByName(name));
        return repository.findAll(spec,pageable);
    }

    public void deleteCategory(int id){
        getCategoryOrErr(id);
        repository.deleteById(id);
    }

    public void updateCategory(int id , Category data){
        getCategoryOrErr(id);
        data.setId(id);
        repository.save(data);
    }

    public void partialUpdateCategory(int id , Category data){
        Category category = getCategoryOrErr(id);
        String name = data.getName() , description = data.getDescription();
        if(name != null) category.setName(name);
        if(description != null) category.setDescription(description);

        repository.save(category);
    }

    public Category getCategoryOrErr(int id){
        return repository.findById(id).orElseThrow(()-> new NotExistsException(Integer.valueOf(id)));
    }


}
