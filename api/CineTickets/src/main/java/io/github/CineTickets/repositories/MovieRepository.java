package io.github.CineTickets.repositories;

import io.github.CineTickets.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie , Integer> {
}
