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
    private String movieTitle;
    private int movieLength;
    private String movieDescription;
    private int ageRequirement;
    private String moviePosterUrl;
    private boolean inRotation = true;




    public Movie() {

    }

    public Movie(String movieTitle, int movieLength, String movieDescription, int ageRequirement, String moviePosterUrl, boolean inRotation) {
        this.movieTitle = movieTitle;
        this.movieLength = movieLength;
        this.movieDescription = movieDescription;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitel) {
        this.movieTitle = movieTitel;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String description) {
        this.movieDescription = description;
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
                ", movieTitel='" + movieTitle + '\'' +
                ", movieLength=" + movieLength +
                ", description='" + movieDescription + '\'' +
                ", ageRequirement=" + ageRequirement +
                ", moviePosterUrl='" + moviePosterUrl + '\'' +
                ", inRotation=" + inRotation +
                '}';
    }
}
