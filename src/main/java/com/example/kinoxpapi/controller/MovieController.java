package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    //SKal vi bruge responseEntity objektet for mere fleksibilitet som returværdi?
    //Skal vi droppe service laget eller skal vi bruge det?

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

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

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int movieId) {
        if (movieRepository.existsById(movieId)){
            movieRepository.deleteById(movieId);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
