package com.example.kinoxpapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class MovieScreening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieScreeningId;
    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;

    @Enumerated(EnumType.STRING)
    private ScreeningTime screeningTime;
    private LocalDate screeningDate;

    private boolean hasPlayed;

    @ManyToOne
    @JoinColumn(name = "auditoriumId", nullable = false)
    private Auditorium auditorium;

    public MovieScreening() {
    }

    public MovieScreening(Movie movie, ScreeningTime screeningTime, LocalDate screeningDate, boolean hasPlayed, Auditorium auditorium) {
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.screeningDate = screeningDate;
        this.hasPlayed = hasPlayed;
        this.auditorium = auditorium;
    }

    public int getMovieScreeningId() {
        return movieScreeningId;
    }

    public void setMovieScreeningId(int movieScreeningId) {
        this.movieScreeningId = movieScreeningId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(LocalDate screeningDate) {
        this.screeningDate = screeningDate;
    }

    public boolean isHasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    @Override
    public String toString() {
        return "MovieScreening{" +
                "movieScreeningId=" + movieScreeningId +
                ", movie=" + movie +
                ", screeningDate=" + screeningDate +
                ", hasPlayed=" + hasPlayed +
                '}';
    }
}
