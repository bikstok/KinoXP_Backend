package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepository;
    @GetMapping("/movies")
    public List<Movie> movies() {
        var movie = movieRepository.findAll();
        return movie;
    }
}
