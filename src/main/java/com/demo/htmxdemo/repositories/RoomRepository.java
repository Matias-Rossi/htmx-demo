package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Optional<Room> getRoomById(String roomCode);

    List<Room> getAllRooms();

    Optional<Room> setRoom(Room room);
    boolean existsRoomWithCode(String roomCode);
    Optional<Room> deleteRoom(Room room);
}
