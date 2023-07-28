package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.models.Reservation;
import com.demo.htmxdemo.models.ReservationType;
import com.demo.htmxdemo.models.Room;

import java.time.LocalDate;

public interface ReservationService {
    public boolean createReservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate, ReservationType type);

    public boolean deleteReservation(Reservation reservation);

    public boolean changeReservationStartDate(Reservation reservation, LocalDate newStartDate);

    public boolean changeReservationEndDate(Reservation reservation, LocalDate newEndDate);

    public boolean changeReservationGuest(Reservation reservation, Guest newGuest);

    public boolean changeReservationRoom(Reservation reservation, Room newRoom);
}
