package com.demo.htmxdemo.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Room {
    private String id;
    private List<Reservation> reservations = new ArrayList<>();
    private Reservation currentReservation;
    private int capacity;
    private boolean hasSharedBed;
    private int floor;

    public Room() {}

    public Room(String id, int capacity, boolean hasSharedBed, int floor) {
        this.id = id;
        this.capacity = capacity;
        this.hasSharedBed = hasSharedBed;
        this.floor = floor;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
