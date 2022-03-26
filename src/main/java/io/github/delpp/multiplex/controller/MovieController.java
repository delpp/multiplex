package io.github.delpp.multiplex.controller;

import io.github.delpp.multiplex.model.Movie;
import io.github.delpp.multiplex.model.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class MovieController {

    private final MovieRepository repository;


    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/movies", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Movie>> realAllMovies(){
        return ResponseEntity.ok(repository.findAll());
    }

}
