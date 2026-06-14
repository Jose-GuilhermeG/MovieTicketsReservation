package io.github.CineTickets.services;

import io.github.CineTickets.exceptions.NotExistsException;
import io.github.CineTickets.models.Movie;
import io.github.CineTickets.repositories.MovieRepository;
import io.github.CineTickets.specifications.MovieSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServices {
    private final MovieRepository repository;

    public Movie createMovie(Movie instance){
        return repository.save(instance);
    }

    public Page<Movie> listMovies(Pageable pageable , String title){
        Specification<Movie> spec = Specification.where(MovieSpecifications.FilterByTitle(title));
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

    private Movie findByIdOrNull(Integer id){
        return repository.findById(id).orElseThrow(()->new NotExistsException(id));
    }

}
