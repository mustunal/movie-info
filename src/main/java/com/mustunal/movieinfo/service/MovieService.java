package com.mustunal.movieinfo.service;

import com.mustunal.movieinfo.domain.Movie;
import com.mustunal.movieinfo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Movie getMovieById(long id) {
        return movieRepository.getMovieById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }
}
