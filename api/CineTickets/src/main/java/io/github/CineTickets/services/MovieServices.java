package io.github.CineTickets.services;

import io.github.CineTickets.exceptions.NotExistsException;
import io.github.CineTickets.models.Category;
import io.github.CineTickets.models.Movie;
import io.github.CineTickets.repositories.CategoryRepository;
import io.github.CineTickets.repositories.MovieRepository;
import io.github.CineTickets.specifications.MovieSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServices {
    private final MovieRepository repository;
    private final CategoryRepository categoryRepository;

    public Movie createMovie(Movie instance , List<Integer> categoriesIds){
        setCategories(instance,categoriesIds);
        return repository.save(instance);
    }

    public Page<Movie> listMovies(Pageable pageable , String title , List<String> categories){
        Specification<Movie> spec = Specification.where(MovieSpecifications.FilterByTitle(title)).and(MovieSpecifications.filterByCategory(categories));
        return repository.findAll(spec , pageable);
    }

    public Movie movieDetail(Integer id){
        Movie instance = findByIdOrNull(id);
        return instance;
    }

    public void deleteMovie(Integer id){
        Movie instance = findByIdOrNull(id);
        repository.deleteById(id);
    }
    
    public Movie updateMovie(int id , Movie data , List<Integer> categoriesIds){
        findByIdOrNull(id);
        data.setId(id);
        setCategories(data,categoriesIds);
        return repository.save(data);
    }

    private Movie findByIdOrNull(Integer id){
        return repository.findById(id).orElseThrow(()->new NotExistsException(id));
    }

    private void setCategories(Movie instance , List<Integer> ids){
        if(ids != null && !ids.isEmpty()){
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(ids));
            checkCategoriesAreFind(categories , ids);
            instance.setCategories((categories));
        };
    }

    private void checkCategoriesAreFind(Set<Category> categories , List<Integer> ids){
        if(categories.isEmpty()) throw new NotExistsException("There are not any category with id in " + ids.toString());
    }

}
