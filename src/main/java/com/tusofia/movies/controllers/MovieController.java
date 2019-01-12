package com.tusofia.movies.controllers;

import com.tusofia.movies.models.binding.CreateMovieBindingModel;
import com.tusofia.movies.services.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController extends BaseController{
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/create")
    public ModelAndView createMovieForm(){

        return this.view("create");
    }

    @PostMapping("/create")
    public ModelAndView createMovie(CreateMovieBindingModel createMovieBindingModel){
        this.movieService.create(createMovieBindingModel);

        return this.redirect("all");
    }

    @GetMapping("/all")
    public ModelAndView allMovies(ModelAndView modelAndView){
        modelAndView.addObject("movies", this.movieService.getAll());

        return this.view("movies", modelAndView);
    }

    @GetMapping("/genre/{genre}")
    public ModelAndView moviesByGenre(ModelAndView modelAndView, @PathVariable String genre){
        modelAndView.addObject("movies", this.movieService.getByGenre(genre));

        return this.view("movies", modelAndView);
    }

    @GetMapping("/country/{country}")
    public ModelAndView moviesByCountry(ModelAndView modelAndView, @PathVariable String country){
        modelAndView.addObject("movies", this.movieService.getByCountry(country));

        return this.view("movies", modelAndView);
    }

    @GetMapping("/year/{year}")
    public ModelAndView moviesByYear(ModelAndView modelAndView, @PathVariable String year){
        modelAndView.addObject("movies", this.movieService.getByYear(year));

        return this.view("movies", modelAndView);
    }

    @GetMapping("/details/{id}")
    public ModelAndView moviesById(ModelAndView modelAndView, @PathVariable String id){
        modelAndView.addObject("movie", this.movieService.findById(id));

        return this.view("details", modelAndView);
    }

    @GetMapping(value = "/api/all", produces = "application/json")
    @ResponseBody
    public Object allStudents(){

        return this.movieService.getAll();
    }
}