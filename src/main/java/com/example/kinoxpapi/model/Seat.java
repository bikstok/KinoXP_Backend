package com.example.kinoxpapi.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private int seatNumber;
    private char rowLetter;

    public Seat(int seatNumber, char rowLetter, Auditorium auditorium) {
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
        this.auditorium = auditorium;
    }

    public Seat() {
    }

    public int getSeatId() {
        return seatId;
    }

    @ManyToOne
    @JoinColumn(name = "auditoriumId", nullable = false)
    private Auditorium auditorium;

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public char getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(char rowLetter) {
        this.rowLetter = rowLetter;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
