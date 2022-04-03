package com.mustunal.movieinfo.controller;

import com.mustunal.movieinfo.domain.Movie;
import com.mustunal.movieinfo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/movie-info")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello World - v1";
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{name}")
    public Movie getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name);
        if (Objects.isNull(movie)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie Not Found!");
        }
        return movie;
    }

    @GetMapping("/getMovieById/{id}")
    public Movie getMovieById(@PathVariable long id){
        Movie movie = movieService.getMovieById(id);
        if (Objects.isNull(movie)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie Not Found!");
        }
        return movie;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
}
