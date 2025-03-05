package com.example.kinoxpapi.confiq;

import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.model.Seat;
import com.example.kinoxpapi.repository.AuditoriumRepository;
import com.example.kinoxpapi.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Override
    public void run(String... args) throws Exception {
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
}
