package io.github.CineTickets.specifications;

import io.github.CineTickets.models.Category;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecifications {
    public static Specification<Category> filterByName(String name){
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name") ,"%" + name + "%");
    }
}
