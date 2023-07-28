package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Room;

public interface RoomService {

    public boolean createRoom(String code, int capacity, boolean hasSharedBed, int floor);

    public boolean deleteRoom(Room room);

    public boolean changeRoomCode(Room room, String newCode);

    public boolean updateReservations(Room room);

    public boolean changeRoomCharacteristics(int capacity, boolean hasSharedBed, int floor);
}
