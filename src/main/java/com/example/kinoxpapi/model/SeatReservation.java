package com.example.kinoxpapi.model;

import jakarta.persistence.*;

@Entity
public class SeatReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "movieScreeningId", nullable = false)
    private MovieScreening movieScreening;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    private boolean isAvailable;
}
