package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:63342")


public class MovieController {

    //SKal vi bruge responseEntity objektet for mere fleksibilitet som returværdi?
    //Skal vi droppe service laget eller skal vi bruge det?

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> movies() {
        return movieService.findAllMovies();
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        Optional<Movie> optionalMovie = movieService.saveMovie(movie);
        if (optionalMovie.isPresent()) {
            return ResponseEntity.ok(optionalMovie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> deactivateMovie(@PathVariable int movieId) {
        Optional<Movie> movie = movieService.deactivateMovie(movieId);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable int movieId) {
        Optional<Movie> movie = movieService.findById(movieId);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fetchMovieByTitle{movieTitle}")
    public ResponseEntity<Movie> fetchMovieByTitle(@PathVariable String movieTitle) {
        Optional<Movie> movie = movieService.findMovieByTitle(movieTitle);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
