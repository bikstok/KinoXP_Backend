package com.example.kinoxpapi.service;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Optional<Movie> deactivateMovie(int movieId){
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalMovie.isPresent() && optionalMovie.get().isInRotation()){
            optionalMovie.get().setInRotation(false);

            movieRepository.save(optionalMovie.get());

            return optionalMovie;
        }

        return optionalMovie;
    }
}
