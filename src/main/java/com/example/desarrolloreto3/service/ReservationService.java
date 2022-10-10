package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Reservation;
import com.example.desarrolloreto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation m) {
        if (m.getIdReservation() == null) {
            return reservationRepository.save(m);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(m.getIdReservation());
            if (e.isPresent()) {
                return m;
            }else{
                return reservationRepository.save(m);
            }
        }

    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Reservation> e = reservationRepository.getReservation(id);
        if (e.isPresent()) {
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}

