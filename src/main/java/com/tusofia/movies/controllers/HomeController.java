package com.tusofia.movies.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends BaseController{
    @Autowired
    private final ModelMapper modelMapper;

    public HomeController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){

        return this.view("index", modelAndView);
    }
}
