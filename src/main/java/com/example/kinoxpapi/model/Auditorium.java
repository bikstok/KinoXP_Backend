package com.example.kinoxpapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auditorium {
    @Id
    private int auditoriumId;
    private int auditoriumNumber;


    public Auditorium() {
    }

    public Auditorium(int auditoriumId, int auditoriumNumber) {
        this.auditoriumId = auditoriumId;
        this.auditoriumNumber = auditoriumNumber;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public int getAuditoriumNumber() {
        return auditoriumNumber;
    }

    public void setAuditoriumNumber(int auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
    }
}
