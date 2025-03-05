package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie postMovie(@RequestBody Movie movie) {
        System.out.println(movie);
        return movieRepository.save(movie);
    }
}
