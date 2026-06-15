package io.github.CineTickets.specifications;

import io.github.CineTickets.models.Movie;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class MovieSpecifications {
    public static Specification<Movie> FilterByTitle(String title){
        return (root, query, criteriaBuilder) ->
                title == null ? null :
                criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Movie> filterByCategory(List<String> categories){
        return  (root, query, criteriaBuilder) ->
                categories == null || categories.isEmpty() ?
                        criteriaBuilder.conjunction() :
                        root.join("categories").get("name").in(categories) ;
    }

}
