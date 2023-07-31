package com.demo.htmxdemo.services;

import com.demo.htmxdemo.controllers.DTOs.RoomRowDTO;
import com.demo.htmxdemo.models.Room;

import java.time.LocalDate;

public interface RoomService {

    boolean createRoom(String code, int capacity, boolean hasSharedBed, int floor);

    boolean deleteRoom(Room room);

    boolean changeRoomCode(Room room, String newCode);

    boolean updateReservations(Room room);

    boolean changeRoomCharacteristics(int capacity, boolean hasSharedBed, int floor);

    String reservedByName(Room room);

    Long reservedByGuestId(Room room);

    LocalDate roomAvailableFrom(Room room);

    RoomRowDTO toRoomRowDTO(Room room);


    boolean isAvailableBetweenDates(Room room, LocalDate startDate, LocalDate endDate);
}
