package com.demo.htmxdemo.data;

import com.demo.htmxdemo.services.GuestService;
import com.demo.htmxdemo.services.RoomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SampleRooms {

    @Autowired
    private RoomService roomService;

    @PostConstruct
    public void init() {
        roomService.createRoom("000", 2, true, 0);
        roomService.createRoom("001", 4, true, 0);
        roomService.createRoom("002", 4, true, 0);
        roomService.createRoom("003", 3, false, 0);
        roomService.createRoom("100", 6, true, 1);
        roomService.createRoom("101", 4, true, 1);
        roomService.createRoom("202", 4, true, 2);
        roomService.createRoom("203", 2, false, 2);
        System.out.println("Sample rooms created");
    }
}
