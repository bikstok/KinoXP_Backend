package com.example.kinoxpapi.controller;


import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://victorious-hill-0c2701803.6.azurestaticapps.net/")
public class AuditoriumController {

    @Autowired
    AuditoriumService auditoriumService;

    @GetMapping("getAuditoriumById/{auditoriumId}")
    public ResponseEntity<Auditorium> getAuditoriumByAuditoriumNumber(@PathVariable int auditoriumId) {
        Optional<Auditorium> optionalAuditorium = auditoriumService.findAuditoriumById(auditoriumId);
        if(optionalAuditorium.isPresent()) {
            return ResponseEntity.ok(optionalAuditorium.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
