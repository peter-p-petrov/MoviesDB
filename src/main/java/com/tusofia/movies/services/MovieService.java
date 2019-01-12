package com.tusofia.movies.services;

import com.tusofia.movies.entities.Movie;
import com.tusofia.movies.models.binding.CreateMovieBindingModel;

import java.util.Set;

public interface MovieService {
    boolean create(CreateMovieBindingModel createMovieBindingModel);
    Set<Movie> getAll();
    Set<Movie> getByGenre(String genre);
    Set<Movie> getByCountry(String country);
    Set<Movie> getByYear(String year);
    Movie findById(String id);
}
