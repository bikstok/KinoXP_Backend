package com.example.kinoxpapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieTitel;
    private int movieLength;
    private String description;
    private int ageRequirement;
    private String moviePosterUrl;
    private boolean inRotation;


    public Movie() {

    }

    public Movie(String movieTitel, int movieLength, String description, int ageRequirement, String moviePosterUrl, boolean inRotation) {
        this.movieTitel = movieTitel;
        this.movieLength = movieLength;
        this.description = description;
        this.ageRequirement = ageRequirement;
        this.moviePosterUrl = moviePosterUrl;
        this.inRotation = inRotation;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitel() {
        return movieTitel;
    }

    public void setMovieTitel(String movieTitel) {
        this.movieTitel = movieTitel;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    public boolean isInRotation() {
        return inRotation;
    }

    public void setInRotation(boolean inRotation) {
        this.inRotation = inRotation;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitel='" + movieTitel + '\'' +
                ", movieLength=" + movieLength +
                ", description='" + description + '\'' +
                ", ageRequirement=" + ageRequirement +
                ", moviePosterUrl='" + moviePosterUrl + '\'' +
                ", inRotation=" + inRotation +
                '}';
    }
}
