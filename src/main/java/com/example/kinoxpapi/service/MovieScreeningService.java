package com.example.kinoxpapi.service;

import com.example.kinoxpapi.model.MovieScreening;
import com.example.kinoxpapi.model.ScreeningTime;
import com.example.kinoxpapi.repository.MovieScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ScreeningTime> getScreeningTimeSlots ()    {
        return Arrays.asList(ScreeningTime.values());
    }

    public Optional<MovieScreening> updateMovieScreening(MovieScreening movieScreening)    {
        return updateMovieScreening(movieScreening);
    }
}
