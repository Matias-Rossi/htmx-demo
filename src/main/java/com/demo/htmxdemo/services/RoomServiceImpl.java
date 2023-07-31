package com.demo.htmxdemo.services;

import com.demo.htmxdemo.controllers.DTOs.RoomRowDTO;
import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.models.Reservation;
import com.demo.htmxdemo.models.Room;
import com.demo.htmxdemo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public boolean createRoom(String code, int capacity, boolean hasSharedBed, int floor) {
        Room room = new Room(code, capacity, hasSharedBed, floor);
        roomRepository.setRoom(room);
        return false;
    }

    @Override
    public boolean deleteRoom(Room room) {
        return roomRepository.deleteRoom(room).isPresent();
    }

    @Override
    public boolean changeRoomCode(Room room, String newCode) {
        return false;
    }

    @Override
    public boolean updateReservations(Room room) {
        // Delete current reservation if necessary
        if (room.getCurrentReservation() != null) {
            if (room.getCurrentReservation().getEndDate().isBefore(LocalDate.now())) {
                room.setCurrentReservation(null);
            }
        }

        // Sort next reservations
        List<Reservation> reservations = room.getReservations();

        reservations.sort(Comparator.comparing(Reservation::getStartDate));

        // Check if new reservation is in place
        Reservation nextReservation = room.getReservations().get(0);

        if(nextReservation.getStartDate().isAfter(LocalDate.now())) {
            room.setCurrentReservation(nextReservation);
        }
        //TODO
        return true;
    }

    @Override
    public boolean changeRoomCharacteristics(int capacity, boolean hasSharedBed, int floor) {
        return false;
    }
    //TODO

    @Override
    public String reservedByName(Room room) {
        Reservation reservation = room.getCurrentReservation();
        if (reservation == null) {
            return "Not reserved";
        }
        Guest guest = reservation.getGuest();
        return guest.getLastName() + ", " + guest.getFirstName();
    }

    @Override
    public Long reservedByGuestId(Room room) {
        Reservation reservation = room.getCurrentReservation();
        if (reservation == null) {
            return (long) -1;
        }
        Guest guest = reservation.getGuest();
        return guest.getGuestId();
    }

    @Override
    public LocalDate roomAvailableFrom(Room room) {
        int reservationQty = room.getReservations().size();
        if (reservationQty == 0) {
            return LocalDate.now();
        }
        Reservation reservation = room.getReservations().get(reservationQty-1);
        return reservation.getEndDate();
    }

    @Override
    public RoomRowDTO toRoomRowDTO(Room room) {
        return new RoomRowDTO(
                room.getId(),
                room.getFloor(),
                reservedByName(room),
                reservedByGuestId(room),
                roomAvailableFrom(room).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                room.getCapacity()
        );
    }

    @Override
    public boolean isAvailableBetweenDates(Room room, LocalDate startDate, LocalDate endDate) {
        return room.getReservations().stream()
                .noneMatch(reservation ->
                        reservation.getStartDate().isBefore(endDate) && reservation.getEndDate().isAfter(startDate));
    }
}
