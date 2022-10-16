package com.example.desarrolloreto3.repository.crudRepository;

import com.example.desarrolloreto3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation as c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation>findAllByStatus(String status);
    public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date DateTwo);

}
