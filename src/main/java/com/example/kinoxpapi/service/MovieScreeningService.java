package com.example.kinoxpapi.service;

import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.model.MovieScreening;
import com.example.kinoxpapi.model.ScreeningTime;
import com.example.kinoxpapi.repository.MovieScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MovieScreeningService {

    @Autowired
    private MovieScreeningRepository movieScreeningRepository;

    public List<MovieScreening> getListOfMovieScreenings() {
        return movieScreeningRepository.findAll();
    }

    public Optional<MovieScreening> deactivateMovieScreening(int movieScreeningId) {
        Optional<MovieScreening> movieScreening = movieScreeningRepository.findById(movieScreeningId);

        if (movieScreening.isPresent()) {
            movieScreening.get().setHasPlayed(true);
            movieScreeningRepository.save(movieScreening.get());
            return movieScreening;
        } else {
            return movieScreening;
        }
    }

    public List<ScreeningTime> getScreeningTimeSlots() {
        return Arrays.asList(ScreeningTime.values());
    }

    public Optional<MovieScreening> createMovieScreening(MovieScreening movieScreening) {
        Optional<MovieScreening> optionalMovieScreening = Optional.of(movieScreeningRepository.save(movieScreening));

        if (optionalMovieScreening.isPresent()){
            return optionalMovieScreening;
        }
        return null;
    }

    public List<MovieScreening> getAllMovieScreeningsNotAvailable(int auditorium, LocalDate date){
        //Need to instansiate an     auditorium object to query the database
        Auditorium newAuditorium = new Auditorium();
        if (auditorium == 1){
            newAuditorium.setAuditoriumId(1);
            newAuditorium.setAuditoriumNumber(1);
        } else if (auditorium == 2){
            newAuditorium.setAuditoriumId(2);
            newAuditorium.setAuditoriumNumber(2);
        }

        return movieScreeningRepository.findByAuditoriumAndScreeningDate(newAuditorium, date);
    }

    public Optional<MovieScreening> updateMovieScreening(MovieScreening movieScreening) {
        return null;
    }
}


