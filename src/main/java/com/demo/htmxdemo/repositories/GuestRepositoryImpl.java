package com.demo.htmxdemo.repositories;

import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.models.Reservation;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

// Database integration is not relevant for this demo, thus it is not included
@Component
public class GuestRepositoryImpl implements GuestRepository {

    private Map<Long, Guest> guests = new HashMap<>();
    private Long lastId = Long.valueOf(0);

    @Override
    public boolean createGuest(Guest guest) {
        Long newId = lastId;
        guest.setGuestId(newId);
        guests.put(newId, guest);
        lastId++;
        return true;
    }

    @Override
    public Optional<Guest> setGuest(Guest guest) {
        Optional<Guest> oldGuest = Optional.ofNullable(guests.get(guest.getGuestId()));
        guests.put(guest.getGuestId(), guest);
        return oldGuest;
    }

    @Override
    public Optional<Guest> getGuestByGuestId(Long guestId) {
        return Optional.ofNullable(guests.get(guestId));
    }

    @Override
    public List<Guest> getGuests(int qty, int offset) {
        if (offset > guests.size()) {
            return new ArrayList<>();
        }

        List<Guest> allGuests = guests.values().stream().collect(Collectors.toList());

        if (guests.size() < offset+qty) {
            qty = guests.size()-offset;
        }

        return allGuests.subList(offset, offset+qty);
    }

    @Override
    public List<Guest> getGuestByGuestNationalId(String nationalId) {
        return guests.values()
                .stream()
                .filter(g -> g.getNationalId() == nationalId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Guest> deleteGuestByGuestId(Long guestId) {
        return Optional.ofNullable(guests.remove(guestId));
    }

    @Override
    public List<Guest> getAllGuests() {
        return guests.values().stream().collect(Collectors.toList());
    }
}
