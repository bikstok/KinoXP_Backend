package com.example.kinoxpapi.service;

import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditoriumService {

    @Autowired
    AuditoriumRepository auditoriumRepository;

    public Optional<Auditorium> findAuditoriumById(int auditoriumId) {
        return auditoriumRepository.findByAuditoriumId(auditoriumId);
    }
}
