package com.demo.htmxdemo.controllers;


import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.repositories.GuestRepository;
import com.demo.htmxdemo.services.GuestService;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    GuestService guestService;

    @Autowired
    GuestRepository guestRepository;

    @GetMapping
    @HxRequest
    public String start(Model model) {
        List<Guest> list = guestRepository.getAllGuests();
        model.addAttribute("guests", list);
        return "/guests/guests";
    }


    @GetMapping("/getGuests")
    @HxRequest
    public String getTableGuests(Model model, @RequestParam Optional<Integer> offset, @RequestParam Optional<Integer> qty) {
        List<Guest> list = guestService.getGuests(qty.orElse(10), offset.orElse(0));

        model.addAttribute("guests", list);

        return "/guests/guestsRow";
    }

    /* GUEST CREATION */

    @GetMapping("/newGuest")
    @HxRequest
    public String newGuestForm(Model model) {
        return "/guests/newGuest";
    }

    @PostMapping
    public ResponseEntity<String> createGuest(Guest guest) {
        guestRepository.createGuest(guest);
        return ResponseEntity.status(201).body("<p>Guest created successfully<p>");
    }

    @DeleteMapping("/{guestId}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long guestId) {
        Optional<Guest> deletedGuest = guestRepository.deleteGuestByGuestId(guestId);
        if (deletedGuest.isPresent()) {
            return ResponseEntity.status(200).body("");
        } else {
            return ResponseEntity.status(404).body("<p>Guest with guest ID " + guestId + " not found<p>");
        }
    }


}
