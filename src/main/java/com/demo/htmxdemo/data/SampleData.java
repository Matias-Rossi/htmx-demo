package com.demo.htmxdemo.data;

import com.demo.htmxdemo.models.Guest;
import com.demo.htmxdemo.models.ReservationType;
import com.demo.htmxdemo.models.Room;
import com.demo.htmxdemo.repositories.GuestRepository;
import com.demo.htmxdemo.repositories.RoomRepository;
import com.demo.htmxdemo.services.GuestService;
import com.demo.htmxdemo.services.ReservationService;
import com.demo.htmxdemo.services.RoomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Component
public class SampleData {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationService reservationService;

    @PostConstruct
    public void init() {
        createSampleGuests();
        createSampleRooms();
        createSampleReservations();
    }


    private void createSampleGuests() {
        guestService.createGuest("24216723", "Juan", "Fernández", LocalDate.of(1974, 4, 21), "jfernandez@mail.com", "12345678");
        guestService.createGuest("31607941", "Alejandro", "González", LocalDate.of(1985, 4, 3), "agonzalez@mail.com", "12345678");
        guestService.createGuest("37463116", "Facundo", "Rodríguez", LocalDate.of(1994, 7, 14), "frodriguez@mail.com", "12345678");
        guestService.createGuest("34586246", "Valentina", "López", LocalDate.of(1991, 1, 20), "vlopez@mail.com", "12345678");
        guestService.createGuest("39784234", "Camila", "Silva", LocalDate.of(1975, 4, 15), "csilva@mail.com", "12345678");
        guestService.createGuest("24367562", "Nicolás", "Gómez", LocalDate.of(1972, 7, 8), "ngomez@mail.com", "12345678");
        guestService.createGuest("21657349", "Lucía", "Rojo", LocalDate.of(1955, 9, 29), "lrojo@mail.com", "12345678");
        guestService.createGuest("19752345", "Agustín", "Álvarez", LocalDate.of(1966, 8, 31), "aalvarez@mail.com", "12345678");
        guestService.createGuest("4324687", "Martina", "Acosta", LocalDate.of(2000, 10, 27), "martu_acosta@mail.com", "12345678");
        guestService.createGuest("67843264", "Matías", "Pérez", LocalDate.of(1969, 12, 24), "mperez@mail.com", "12345678");
        guestService.createGuest("94573648", "Julián", "Morales", LocalDate.of(1985, 11, 16), "jmorales@mail.com", "12345678");
        guestService.createGuest("42486279", "Pedro", "Roberto", LocalDate.of(1971, 3, 26), "pedro_roberto@mail.com", "12345678");
        guestService.createGuest("17954626", "María", "Lorenzo", LocalDate.of(1951, 2, 8), "mlorenzo@mail.com", "12345678");
        System.out.println("Sample guests created");
    }

    private void createSampleRooms() {
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
    private void createSampleReservations() {
        LocalDate now = LocalDate.now();
        LocalDate currentReservationDate = LocalDate.now().minusDays(2);
        // 000
        Room room = roomRepository.getRoomById("000").get();
        Guest guest = guestRepository.getGuestByGuestNationalId("24216723").get(0);
        reservationService.createReservation(guest, room, currentReservationDate, now.plusDays(2), ReservationType.RESERVATION);

        guest = guestRepository.getGuestByGuestNationalId("31607941").get(0);
        reservationService.createReservation(guest, room, now.plusDays(3), now.plusDays(7), ReservationType.RESERVATION);

        // 001
        room = roomRepository.getRoomById("001").get();
        guest = guestRepository.getGuestByGuestNationalId("37463116").get(0);
        reservationService.createReservation(guest, room, now.plusDays(5), now.plusDays(8), ReservationType.RESERVATION);

        // 203
        room = roomRepository.getRoomById("203").get();
        guest = guestRepository.getGuestByGuestNationalId("94573648").get(0);
        reservationService.createReservation(guest, room, currentReservationDate, now.plusDays(8), ReservationType.RESERVATION);
    }

}
