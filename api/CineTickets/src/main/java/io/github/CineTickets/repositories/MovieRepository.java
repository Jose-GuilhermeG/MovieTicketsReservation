package io.github.CineTickets.repositories;

import io.github.CineTickets.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieRepository extends JpaRepository<Movie , Integer> , JpaSpecificationExecutor<Movie> {
}
