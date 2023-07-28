package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    public boolean createReservation(Reservation reservation);

    public Optional<Reservation> getReservationById(Long id);

    public List<Reservation> getReservationsForRoom(String roomId);

    public List<Reservation> getReservationsForRoomBetweenDates(String roomId, LocalDate startDate, LocalDate endDate);

    public Optional<Reservation> deleteReservation(Long id);
}
