package com.demo.htmxdemo.controllers.DTOs;

import lombok.Data;

@Data
public class RoomRowDTO {
    private String roomId;
    private int floor;
    private String reservedByName;
    private Long reservedById;
    private String availableFrom;
    private int capacity;

    public RoomRowDTO() {
    }

    public RoomRowDTO(String roomId, int floor, String reservedByName, Long reservedById, String availableFrom, int capacity) {
        this.roomId = roomId;
        this.floor = floor;
        this.reservedByName = reservedByName;
        this.reservedById = reservedById;
        this.availableFrom = availableFrom;
        this.capacity = capacity;
    }
}
