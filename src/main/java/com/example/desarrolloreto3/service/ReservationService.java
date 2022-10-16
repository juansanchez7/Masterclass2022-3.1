package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Reservation;
import com.example.desarrolloreto3.personalentity.CountClient;
import com.example.desarrolloreto3.personalentity.StatusAmount;
import com.example.desarrolloreto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            } else {
                return reservationRepository.save(m);
            }
        }

    }

    public Reservation update(Reservation m) {
        if (m.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(m.getIdReservation());
            if (e.isPresent()) {
                if (m.getStartDate() != null) {
                    e.get().setStartDate(m.getStartDate());
                }
                if (m.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(m.getDevolutionDate());
                }
                if (m.getStatus() != null) {
                    e.get().setStatus(m.getStatus());
                }
                return reservationRepository.save(e.get());
            }
        }
        return m;
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

    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }

    public StatusAmount getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationPeriod(a, b);
        } else {
            return new ArrayList<>();
        }
    }

}

