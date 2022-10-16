package com.example.desarrolloreto3.repository;

import com.example.desarrolloreto3.entities.Client;
import com.example.desarrolloreto3.entities.Reservation;
import com.example.desarrolloreto3.personalentity.CountClient;
import com.example.desarrolloreto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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


    public List<CountClient>getTopClients(){
        List<CountClient> resultado = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i< report.size();i++){
            resultado.add(new CountClient((Long)report.get(i)[1], (Client)report.get(i)[0]));
        }
        return resultado;
    }

    public List<Reservation>getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<Reservation>getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }


}

