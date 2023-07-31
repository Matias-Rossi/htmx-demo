package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation createReservation(Reservation reservation);

    Optional<Reservation> getReservationById(Long id);

    List<Reservation> getReservationsForRoom(String roomId);

    List<Reservation> getReservationsForRoomBetweenDates(String roomId, LocalDate startDate, LocalDate endDate);

    Optional<Reservation> deleteReservation(Long id);
}
