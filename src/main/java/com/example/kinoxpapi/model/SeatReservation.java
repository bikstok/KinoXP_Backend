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

    public SeatReservation(Seat seat, MovieScreening movieScreening, boolean isAvailable) {
        this.seat = seat;
        this.movieScreening = movieScreening;
        this.isAvailable = isAvailable;
    }

    public SeatReservation() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public MovieScreening getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(MovieScreening movieScreening) {
        this.movieScreening = movieScreening;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
