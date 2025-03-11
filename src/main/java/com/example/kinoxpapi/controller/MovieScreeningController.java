package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.MovieScreening;
import com.example.kinoxpapi.service.MovieScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class MovieScreeningController {

    @Autowired
    MovieScreeningService movieScreeningService;

    @GetMapping("/showMovieScreenings")
    public List<MovieScreening> getListOfMovieScreenings()  {
        System.out.println(movieScreeningService.getListOfMovieScreenings());
        return movieScreeningService.getListOfMovieScreenings();
    }

    @PutMapping("deactivateMovieScreening/{movieScreeningId}")
    public ResponseEntity<MovieScreening> deactivateMovieScreening(@PathVariable int movieScreeningId) {
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.deactivateMovieScreening(movieScreeningId);

        if(optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
