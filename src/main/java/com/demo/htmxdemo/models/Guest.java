package com.demo.htmxdemo.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Guest {
    private Long guestId;
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private List<Reservation> reservations = new ArrayList<>();

    public Guest() {
    }

    public Guest(String nationalId, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
