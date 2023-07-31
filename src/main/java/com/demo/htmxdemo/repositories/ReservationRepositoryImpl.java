package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Database integration is not relevant for this demo, thus it is not included
@Component
public class ReservationRepositoryImpl implements ReservationRepository {
    private final Map<Long, Reservation> reservations = new HashMap<>();
    private Long lastId = 0L;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        Long newId = lastId;
        reservation.setId(newId);
        reservations.put(newId, reservation);
        lastId++;

        reservation.getRoom().addReservation(reservation);
        roomRepository.setRoom(reservation.getRoom());

        reservation.getGuest().addReservation(reservation);
        guestRepository.setGuest(reservation.getGuest());

        return reservation;
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return Optional.ofNullable(reservations.get(id));
    }

    @Override
    public List<Reservation> getReservationsForRoom(String roomId) {
        return reservations.values()
                .stream()
                .filter(res -> res.getRoom().getId().equalsIgnoreCase(roomId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsForRoomBetweenDates(String roomId, LocalDate startDate, LocalDate endDate) {
        return reservations.values()
                .stream()
                .filter(res -> res.getRoom().getId().equalsIgnoreCase(roomId))
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
