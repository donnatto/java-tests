package com.donnatto.javatests.movies.service;

import com.donnatto.javatests.movies.data.MovieRepository;
import com.donnatto.javatests.movies.model.Genre;
import com.donnatto.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository repository = Mockito.mock(MovieRepository.class);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(
                        new Movie(1, "a", 152, Genre.ACTION),
                        new Movie(2, "b", 112, Genre.THRILLER),
                        new Movie(3, "c", 119, Genre.COMEDY),
                        new Movie(4, "d", 111, Genre.THRILLER),
                        new Movie(5, "e", 103, Genre.HORROR),
                        new Movie(6, "f", 136, Genre.COMEDY)
                ));

        movieService = new MovieService(repository);
    }

    @Test
    public void returnMoviesByGenre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> movieIds = getMovieIds(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3, 6)));

    }

    @Test
    public void returnMoviesByLength() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);

        List<Integer> movieIds = getMovieIds(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(2, 3, 4, 5)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}