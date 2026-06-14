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

}
