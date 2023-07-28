package com.demo.htmxdemo.controllers;

import com.demo.htmxdemo.models.Room;
import com.demo.htmxdemo.repositories.RoomRepository;
import com.demo.htmxdemo.services.RoomService;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomRepository roomRepository;

    @GetMapping
    @HxRequest
    public String start(Model model) {
        List<Room> list = roomRepository.getAllRooms();
        model.addAttribute("rooms", list);
        return "/rooms/rooms";
    }
}
