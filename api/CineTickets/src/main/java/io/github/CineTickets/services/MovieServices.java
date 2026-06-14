package io.github.CineTickets.services;

import io.github.CineTickets.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository repository;


}
