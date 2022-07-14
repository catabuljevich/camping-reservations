package com.techelevator.models.dao;

import com.techelevator.models.dto.Park;
import com.techelevator.models.dto.Reservation;

import java.util.List;

public interface ReservationDao {


    List<Reservation> getAllReservations();

    Reservation getReservationById(int reservationId);


}
