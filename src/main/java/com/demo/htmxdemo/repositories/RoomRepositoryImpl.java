package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Room;
import org.springframework.stereotype.Component;

import java.util.*;

// Database integration is not relevant for this demo, thus it is not included
@Component
public class RoomRepositoryImpl implements RoomRepository {
    private Map<String, Room> rooms = new HashMap<>();

    public RoomRepositoryImpl() {
    }

    @Override
    public Optional<Room> getRoomById(String roomCode) {
        return Optional.ofNullable(rooms.get(roomCode));
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms.values().stream().sorted(
                Comparator.comparing(Room::getId)
        ).toList();
    }

    @Override
    public Optional<Room> setRoom(Room room) {
        String roomCode = room.getId();
        Optional<Room> oldRoom = Optional.ofNullable(rooms.get(roomCode));
        rooms.put(roomCode, room);
        return oldRoom;
    }

    @Override
    public boolean existsRoomWithCode(String roomCode) {
        return rooms.containsKey(roomCode);
    }

    @Override
    public Optional<Room> deleteRoom(Room room) {
        return Optional.ofNullable(rooms.remove(room.getId()));
    }
}
