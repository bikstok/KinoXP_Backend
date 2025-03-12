package com.example.kinoxpapi.confiq;

import com.example.kinoxpapi.model.*;
import com.example.kinoxpapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final MovieScreeningRepository movieScreeningRepository;
    private final SeatReservationRepository seatReservationRepository;
    private final BookingRepository bookingRepository;

    public InitData(MovieRepository movieRepository, SeatRepository seatRepository,
                    AuditoriumRepository auditoriumRepository, MovieScreeningRepository movieScreeningRepository,
                    SeatReservationRepository seatReservationRepository, BookingRepository bookingRepository) {
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieScreeningRepository = movieScreeningRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Create Auditoriums and Seats
        //    - Auditoriums must be created first, as seats need to be associated with them.

        // 2. Create Movies
        //    - Movies must be created before screenings, as screenings are linked to specific movies.

        // 3. Create Movie Screenings and associate them with a movie and an auditorium
        //    - Movie screenings require both a movie and an auditorium to be linked.

        // 4. Create Seat Reservations and associate them with a Movie Screening and a specific Seat
        //    - Seat reservations need a movie screening and a seat to be valid.

        // 5. Create Bookings and link them to Seat Reservations
        //    - Bookings can be created independently, but must be connected to seat reservations.


        Auditorium auditorium1 = auditoriumRepository.save(new Auditorium(1, 1));
        Auditorium auditorium2 = auditoriumRepository.save(new Auditorium(2, 2));


        List<Seat> smallRoom = new ArrayList<>();
        List<Seat> bigRoom = new ArrayList<>();
        smallRoom.addAll(generateSeats(auditorium1, 20, 12));
        bigRoom.addAll(generateSeats(auditorium2, 25, 16));


        seatRepository.saveAll(smallRoom);
        seatRepository.saveAll(bigRoom);

        Movie movie2 = new Movie("The Dark Knight", 152, "Batman faces Joker in Gotham.", 13, "https://image.url/dark-knight.jpg", true);
        Movie movie3 = new Movie("Interstellar", 169, "A journey beyond our galaxy.", 10, "https://image.url/interstellar.jpg", false);

        Movie movie1 = new Movie("Inception", 148, "A thief enters dreams to steal secrets.", 13, "https://xl.movieposterdb.com/14_09/2014/816692/xl_816692_2beaba6e.jpg?v=2025-02-10%2020:28:48", true);
        MovieScreening movieScreening = new MovieScreening(movie1, ScreeningTime.TIME_14_00, LocalDate.now(), false, auditorium2);
        Seat seat = seatRepository.getById(67);

        SeatReservation seatReservation = new SeatReservation(seat, movieScreening, true);

        Booking booking = new Booking("Miakhalifa69@hotmail.com");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieScreeningRepository.save(movieScreening);
        seatReservationRepository.save(seatReservation);
        bookingRepository.save(booking);

        seatReservation.setBooking(booking);

        seatReservationRepository.save(seatReservation);
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

}

