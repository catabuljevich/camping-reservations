package com.techelevator.models.dao;

import com.techelevator.models.dto.Reservation;
import com.techelevator.models.dto.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcReservationDao implements ReservationDao{

    JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Reservation> getAllReservations() {
        List <Reservation> reservations= new ArrayList<>();
        String sql = "SELECT reservation_id " +
                "     , site_id " +
                "     , name " +
                "     , from_date " +
                "     , to_date " +
                "     , create_date " +
                " FROM reservation;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            reservations.add(mapRowToReservations(results));
        }
        return reservations;
    }




    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation myReservation = null;

        String sql ="SELECT reservation_id " +
                "     , site_id " +
                "     , name " +
                "     , from_date " +
                "     , to_date " +
                "     , create_date " +
                " FROM reservation " +
                " WHERE reservation_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationId);
        if (results.next()) {
            myReservation  = mapRowToReservations(results);
        }
        return myReservation;
    }

    private Reservation mapRowToReservations(SqlRowSet results) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(results.getInt("reservation_id"));
        reservation.setSiteId(results.getInt("site_id"));
        reservation.setName(results.getString("name"));
        reservation.setFromDate(results.getDate("from_date").toLocalDate());
        reservation.setToDate(results.getDate("to_date").toLocalDate());
        reservation.setCreateDate(results.getDate("create_date").toLocalDate());
        return  reservation;

    }
}
