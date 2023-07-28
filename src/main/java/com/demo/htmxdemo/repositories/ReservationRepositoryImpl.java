package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Reservation;
import com.demo.htmxdemo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

// Database integration is not relevant for this demo, thus it is not included
@Component
public class ReservationRepositoryImpl implements ReservationRepository {
    private Map<Long, Reservation> reservations = new HashMap<>();
    private Long lastId = Long.valueOf(0);

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public boolean createReservation(Reservation reservation) {
        Long newId = lastId;
        reservation.setId(newId);
        reservations.put(newId, reservation);
        lastId++;

        reservation.getRoom().addReservation(reservation);
        roomRepository.setRoom(reservation.getRoom());

        reservation.getGuest().addReservation(reservation);
        guestRepository.setGuest(reservation.getGuest());

        return true;
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return Optional.ofNullable(reservations.get(id));
    }

    @Override
    public List<Reservation> getReservationsForRoom(String roomId) {
        return reservations.values()
                .stream()
                .filter(res -> res.getRoom().getId() == roomId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsForRoomBetweenDates(String roomId, LocalDate startDate, LocalDate endDate) {
        return reservations.values()
                .stream()
                .filter(res -> res.getRoom().getId() == roomId)
                .filter(res -> res.getStartDate().isAfter(startDate) || res.getStartDate().isEqual(startDate))
                .filter(res -> res.getEndDate().isAfter(endDate) || res.getEndDate().isEqual(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reservation> deleteReservation(Long id) {
        try {
            Reservation reservation = reservations.get(id);
            roomRepository.getRoomById(reservation.getRoom().getId())
                    .get().removeReservation(reservation);

            guestRepository.getGuestByGuestId(reservation.getGuest().getGuestId())
                    .get().removeReservation(reservation);

            return Optional.ofNullable(reservations.remove(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
