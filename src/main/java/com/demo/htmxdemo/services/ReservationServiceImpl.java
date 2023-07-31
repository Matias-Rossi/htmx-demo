package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.models.Reservation;
import com.demo.htmxdemo.models.ReservationType;
import com.demo.htmxdemo.models.Room;
import com.demo.htmxdemo.repositories.GuestRepository;
import com.demo.htmxdemo.repositories.ReservationRepository;
import com.demo.htmxdemo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @Override
    public boolean createReservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate, ReservationType type) {
        if (endDate.isBefore(startDate)) {
            return false;
        }

        if (!roomService.isAvailableBetweenDates(room, startDate, endDate)) {
            return false;
        }

        Reservation reservation = new Reservation(null, guest, room, startDate, endDate, type);
        reservation = reservationRepository.createReservation(reservation);
        guest.addReservation(reservation);
        room.addReservation(reservation);
        roomService.updateReservations(room);
        return true;
    }

    @Override
    public boolean deleteReservation(Reservation reservation) {
        //TODO
        return false;
    }

    @Override
    public boolean changeReservationStartDate(Reservation reservation, LocalDate newStartDate) {
        //TODO
        return false;
    }

    @Override
    public boolean changeReservationEndDate(Reservation reservation, LocalDate newEndDate) {
        //TODO
        return false;
    }

    @Override
    public boolean changeReservationGuest(Reservation reservation, Guest newGuest) {
        //TODO
        return false;
    }

    @Override
    public boolean changeReservationRoom(Reservation reservation, Room newRoom) {
        //TODO
        return false;
    }
}
