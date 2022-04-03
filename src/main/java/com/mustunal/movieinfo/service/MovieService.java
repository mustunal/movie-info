package com.mustunal.movieinfo.service;

import com.mustunal.movieinfo.domain.Director;
import com.mustunal.movieinfo.domain.Movie;
import com.mustunal.movieinfo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    @Autowired
    public MovieService(MovieRepository movieRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieRepository.getMovieByName(name);
        if (Objects.nonNull(movie)) {
            Director director = getDirectorById(movie.getDirectorId());
            movie.setDirector(director);
        }
        return movie;
    }

    public Movie getMovieById(long id) {
        Movie movie = movieRepository.getMovieById(id);

        return movie;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    private Director getDirectorById(long id){
        return directorService.getDirectorById(id);
    }
}
