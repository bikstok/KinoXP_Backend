package com.example.kinoxpapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MovieScreening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieScreeningId;
    @ManyToOne
    @JoinColumn(name = "movieidfk", referencedColumnName = "movieId", nullable = false)
    private Movie movie;

    @Enumerated(EnumType.STRING)
    private ScreeningTime screeningTime;
    private Date screeningDate;

    private boolean hasPlayed;

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

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
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
