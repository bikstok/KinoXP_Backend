package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
