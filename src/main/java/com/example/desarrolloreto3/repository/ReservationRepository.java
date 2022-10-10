package com.example.desarrolloreto3.repository;

import com.example.desarrolloreto3.entities.Reservation;
import com.example.desarrolloreto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation m) {
        return reservationCrudRepository.save(m);
    }

    public void delete(Reservation m) {
        reservationCrudRepository.delete(m);
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
}

