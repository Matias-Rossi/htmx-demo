package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestRepository {
    public boolean createGuest(Guest guest);
    public Optional<Guest> setGuest(Guest guest);
    public Optional<Guest> getGuestByGuestId(Long guestId);
    public List<Guest> getGuests(int qty, int offset);
    public List<Guest> getGuestByGuestNationalId(String nationalId);
    public Optional<Guest> deleteGuestByGuestId(Long guestId);

    public List<Guest> getAllGuests();
}
