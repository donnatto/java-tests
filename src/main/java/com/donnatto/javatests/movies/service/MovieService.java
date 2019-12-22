package com.donnatto.javatests.movies.service;

import com.donnatto.javatests.movies.data.MovieRepository;
import com.donnatto.javatests.movies.model.Genre;
import com.donnatto.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        Collection<Movie> genreMovies = repository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

        return genreMovies;
    }

    public Collection<Movie> findMoviesByLength(int length) {

        Collection<Movie> lengthMovies = repository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());

        return lengthMovies;
    }
}
