package com.demo.htmxdemo.services;

import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestRepository guestRepository;

    @Override
    public boolean createGuest(String nationalId, String firstName, String lastName,  LocalDate dateOfBirth, String email, String phoneNumber) {
        Guest guest = new Guest(nationalId, firstName, lastName, dateOfBirth, email, phoneNumber);
        return guestRepository.createGuest(guest);
    }

    @Override
    public List<Guest> getGuests(int qty, int offset) {
        return guestRepository.getGuests(qty, offset);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.getAllGuests();

    }

    @Override
    public boolean deleteGuest(Guest guest) {
        return guestRepository.deleteGuestByGuestId(guest.getGuestId()).isPresent();
    }
}
