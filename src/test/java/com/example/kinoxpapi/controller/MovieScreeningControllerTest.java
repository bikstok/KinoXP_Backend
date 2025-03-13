package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.*;
import com.example.kinoxpapi.repository.AuditoriumRepository;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.repository.MovieScreeningRepository;
import com.example.kinoxpapi.service.MovieScreeningService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
class MovieScreeningControllerTest {

    @Autowired
    MovieScreeningService movieScreeningService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    AuditoriumRepository auditoriumRepository;
    @Autowired
    MovieScreeningRepository movieScreeningRepository;



    @Transactional
    @Test
    void getNonAvailableTimeslots() {

        Auditorium auditorium1 = auditoriumRepository.save(new Auditorium(1, 1));
        Auditorium auditorium2 = auditoriumRepository.save(new Auditorium(2, 2));






        Movie movie2 = new Movie("The Dark Knight", 152, "Batman faces Joker in Gotham.", 13, "https://image.url/dark-knight.jpg", true);
        Movie movie3 = new Movie("Interstellar", 169, "A journey beyond our galaxy.", 10, "https://image.url/interstellar.jpg", false);

        Movie movie1 = new Movie("Inception", 148, "A thief enters dreams to steal secrets.", 13, "https://xl.movieposterdb.com/14_09/2014/816692/xl_816692_2beaba6e.jpg?v=2025-02-10%2020:28:48", true);
        MovieScreening movieScreening = new MovieScreening(movie1, ScreeningTime.TIME_14_00, LocalDate.now(), false, auditorium2);

        Booking booking = new Booking("Miakhalifa69@hotmail.com");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieScreeningRepository.save(movieScreening);


        int auditorium = 1;
        LocalDate today = LocalDate.now();

        List<MovieScreening> movieScreeningList = movieScreeningService.getAllMovieScreeningsNotAvailable(auditorium, today);

        assertTrue(movieScreeningList.size() > 0, "Der bør være mindst én filmvisning i dag.");


        for (MovieScreening screening : movieScreeningList) {
            assertEquals(auditorium, screening.getAuditorium().getAuditoriumId(),
                    "Filmvisning skal være i auditorium " + auditorium);
            assertEquals(today, screening.getScreeningDate(), "Filmens visningsdato skal være " + today);
        }
    }
}