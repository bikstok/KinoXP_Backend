package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.MovieScreening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieScreeningRepository extends JpaRepository<MovieScreening, Integer> {

    List<MovieScreening> findByAuditoriumAndScreeningDate(int auditorium, String date);

}
