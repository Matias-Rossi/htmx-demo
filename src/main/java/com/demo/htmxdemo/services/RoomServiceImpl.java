package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Room;
import com.demo.htmxdemo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        //TODO
        return true;
    }

    @Override
    public boolean changeRoomCharacteristics(int capacity, boolean hasSharedBed, int floor) {
        return false;
    }
    //TODO
}
