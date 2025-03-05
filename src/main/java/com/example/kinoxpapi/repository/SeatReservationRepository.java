package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer> {
}
