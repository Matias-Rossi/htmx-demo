package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Guest;

import java.time.LocalDate;
import java.util.List;

public interface GuestService {
    public boolean createGuest(String nationalId, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber);
    public List<Guest> getGuests(int qty, int offset);
    public List<Guest> getAllGuests();
    public boolean deleteGuest(Guest guest);
}
