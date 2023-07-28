package com.demo.htmxdemo.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reservation {
    private Long id;
    private Guest guest;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationType type;

    public Reservation() {
    }

    public Reservation(Long id, Guest guest, Room room, LocalDate startDate, LocalDate endDate, ReservationType type) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }
}
