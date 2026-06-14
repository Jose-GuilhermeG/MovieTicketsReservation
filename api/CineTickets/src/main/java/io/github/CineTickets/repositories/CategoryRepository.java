package io.github.CineTickets.repositories;

import io.github.CineTickets.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category , Integer> , JpaSpecificationExecutor<Category> {
    Boolean existsByName(String name);
}
