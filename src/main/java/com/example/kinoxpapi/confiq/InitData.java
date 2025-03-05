package com.example.kinoxpapi.confiq;

import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.model.Seat;
import com.example.kinoxpapi.repository.AuditoriumRepository;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeMovies();

        if (seatRepository.count() == 0) {


            Auditorium auditorium1 = auditoriumRepository.save(new Auditorium(1, 1));
            Auditorium auditorium2 = auditoriumRepository.save(new Auditorium(2, 2));

            List<Seat> smallRoom = new ArrayList<>();
            List<Seat> bigRoom = new ArrayList<>();
            smallRoom.addAll(generateSeats(auditorium1, 20, 12));
            bigRoom.addAll(generateSeats(auditorium2, 25, 16));


            seatRepository.saveAll(smallRoom);
            seatRepository.saveAll(bigRoom);
            System.out.println("Sæder er oprettet i databasen!");
        } else {
            System.out.println("Sæder findes allerede i databasen.");
        }
    }

    private List<Seat> generateSeats(Auditorium auditorium, int numRows, int seatsPerRow) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            char rowLetter = (char) ('A' + row);
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat();
                seat.setRowLetter(rowLetter);
                seat.setSeatNumber(seatNum);
                seat.setAuditorium(auditorium);
                seats.add(seat);
            }
        }
        return seats;
    }

    private void initializeMovies() {
        if (movieRepository.count() == 0) {
            System.out.println("Initializing movies in the database...");

            addMovie("Inception", 148, "A thief enters dreams to steal secrets.", 13, "https://xl.movieposterdb.com/14_09/2014/816692/xl_816692_2beaba6e.jpg?v=2025-02-10%2020:28:48", true);
            addMovie("The Dark Knight", 152, "Batman faces Joker in Gotham.", 13, "https://image.url/dark-knight.jpg", true);
            addMovie("Interstellar", 169, "A journey beyond our galaxy.", 10, "https://image.url/interstellar.jpg", false);

            System.out.println("Movies have been added to the database");
        } else {
            System.out.println("Movies already exist in the database.");
        }
    }

    private void addMovie(String title, int length, String description, int ageRequirement, String posterUrl, boolean inRotation) {
        Movie movie = new Movie(title, length, description, ageRequirement, posterUrl, inRotation);
        movieRepository.save(movie);
        System.out.println("Added movie: " + title);
    }
}

