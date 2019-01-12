package com.tusofia.movies.services;

import com.tusofia.movies.entities.Movie;
import com.tusofia.movies.models.binding.CreateMovieBindingModel;
import com.tusofia.movies.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements MovieService{
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieServiceImp(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean create(CreateMovieBindingModel createMovieBindingModel) {
        Movie movie = this.modelMapper.map(createMovieBindingModel, Movie.class);

        return this.movieRepository.save(movie) != null;
    }

    @Override
    public Set<Movie> getAll() {
        return this.movieRepository
                .findAll()
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<Movie> getByGenre(String genre) {
        Set<Movie> allMovies = getAll();
        Set<Movie> resultCollection = new HashSet<Movie>();

        for (Movie movie: allMovies) {
            if (movie.getGenre().equals(genre)) {
                resultCollection.add(movie);
            }
        }

        return resultCollection;
    }

    @Override
    public Set<Movie> getByCountry(String country) {
        Set<Movie> allMovies = getAll();
        Set<Movie> resultCollection = new HashSet<Movie>();

        for (Movie movie: allMovies) {
            if (movie.getCountry().equals(country)) {
                resultCollection.add(movie);
            }
        }

        return resultCollection;
    }

    @Override
    public Set<Movie> getByYear(String year) {
        Set<Movie> allMovies = getAll();
        Set<Movie> resultCollection = new HashSet<Movie>();

        for (Movie movie: allMovies) {
            if (movie.getYear().toString().equals(year)) {
                resultCollection.add(movie);
            }
        }

        return resultCollection;
    }

    @Override
    public Movie findById(String id) {
        return this.movieRepository
                .findById(id)
                .orElse(null);
    }
}