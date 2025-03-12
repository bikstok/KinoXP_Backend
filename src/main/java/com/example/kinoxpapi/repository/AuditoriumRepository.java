package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

    Optional<Auditorium> findByAuditoriumId(Integer auditoriumId);
}
