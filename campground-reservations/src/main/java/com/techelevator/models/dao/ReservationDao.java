package com.techelevator.models.dao;

import com.techelevator.models.dto.Park;
import com.techelevator.models.dto.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {


    List<Reservation> getAllReservations();

    Reservation getReservationById(int reservationId);

     Reservation createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate, LocalDate today);


}
