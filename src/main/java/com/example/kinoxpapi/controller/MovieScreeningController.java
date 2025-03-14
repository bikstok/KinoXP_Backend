package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.MovieScreening;
import com.example.kinoxpapi.model.ScreeningTime;
import com.example.kinoxpapi.service.AuditoriumService;
import com.example.kinoxpapi.service.MovieScreeningService;
import com.example.kinoxpapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://victorious-hill-0c2701803.6.azurestaticapps.net/")
@RestController
public class MovieScreeningController {

    @Autowired
    MovieScreeningService movieScreeningService;
    @Autowired
    MovieService movieService;
    @Autowired
    AuditoriumService auditoriumService;

    @GetMapping("/showMovieScreenings")
    public List<MovieScreening> getListOfMovieScreenings() {
        return movieScreeningService.getListOfMovieScreenings();
    }

    @PostMapping("/movieScreening")
    public ResponseEntity<MovieScreening> createMovieScreening(@RequestBody MovieScreening movieScreening) {

        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.createMovieScreening(movieScreening);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("deactivateMovieScreening/{movieScreeningId}")
    public ResponseEntity<MovieScreening> deactivateMovieScreening(@PathVariable int movieScreeningId) {
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.deactivateMovieScreening(movieScreeningId);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getScreeningTimeSlots")
    public List<ScreeningTime> getScreeningTimeSlots() {
        return movieScreeningService.getScreeningTimeSlots();
    }


    @PutMapping("updateMovieScreening")
    public ResponseEntity<MovieScreening> updateMovieScreening(@RequestBody MovieScreening movieScreening) {
        System.out.println(movieScreening);
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.updateMovieScreening(movieScreening);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/movieScreenings/{auditorium}/{date}")
    public List<MovieScreening> getNonAvailableTimeslots(@PathVariable("auditorium") int auditorium, @PathVariable("date") LocalDate date){

        return movieScreeningService.getAllMovieScreeningsNotAvailable(auditorium, date);
    }
}


