package com.mustunal.movieinfo.repository;

import com.mustunal.movieinfo.domain.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MovieRepository {

    private final Map<String, Movie>  movieMap = new HashMap<>();

    public MovieRepository(){
        initMovieMap();
    }

    public List<Movie> getAllMovies(){
        return new ArrayList<>(movieMap.values());
    }

    private void initMovieMap() {
        Movie movie = new Movie(1,"Esaretin Bedeli");
        movieMap.put(movie.getName(),movie);
        movie = new Movie(2,"Dövüş Kulübü");
        movieMap.put(movie.getName(),movie);
        movie = new Movie(3,"Baba 2");
        movieMap.put(movie.getName(),movie);
    }

    public Movie getMovieByName(String name) {
        return movieMap.get(name);
    }

    public Movie getMovieById(long id) {
        List<Movie> movieList = new ArrayList<>(movieMap.values());
        return movieList.stream().filter(m-> m.getId() == id).findFirst().orElse(null);
    }

    public Movie addMovie(Movie movie) {
        long id = movieMap.size() + 1;
        Movie newMovie = new Movie(id,movie.getName());

        movieMap.put(newMovie.getName(),newMovie);

        return  newMovie;
    }
}
