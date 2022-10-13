package com.example.desarrolloreto3.controller;

import com.example.desarrolloreto3.entities.Reservation;
import com.example.desarrolloreto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();}
        @GetMapping("/{id}")
        public Optional<Reservation> getReservation(@PathVariable("id") int id) {
            return reservationService.getReservation(id);
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Reservation save(@RequestBody Reservation m) {
            return reservationService.save(m);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Reservation update(@RequestBody Reservation m) {
            return reservationService.update(m);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("id") int id) {
            return reservationService.delete(id);
        }
    }
