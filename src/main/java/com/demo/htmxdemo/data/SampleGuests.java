package com.demo.htmxdemo.data;

import com.demo.htmxdemo.services.GuestService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SampleGuests {

    @Autowired
    private GuestService guestService;

    @PostConstruct
    public void init() {
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
}
