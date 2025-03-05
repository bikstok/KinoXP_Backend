package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
