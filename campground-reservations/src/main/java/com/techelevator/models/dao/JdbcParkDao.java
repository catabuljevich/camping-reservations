package com.techelevator.models.dao;

import com.techelevator.models.dto.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao
{
    static JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public  List<Park> getAllParks()
    {
        List <Park> parks= new ArrayList<>();
        String sql = "SELECT park_id " +
                "     , name " +
                "     , location " +
                "     , establish_date " +
                "     , area " +
                "     , visitors " +
                "     , description " +
                " FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;

    }


    @Override
    public Park getParkById(int parkId)
    {
        Park myPark = null;

        String sql = "SELECT park_id " +
                "     , name " +
                "     , location " +
                "     , establish_date " +
                "     , area " +
                "     , visitors " +
                "     , description " +
                "FROM park\n" +
                "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            myPark = mapRowToPark(results);
        }
        return myPark;
    }
    private static Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setDate(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getInt("area"));
        park.setVisitors(results.getInt("visitors"));
        park.setDescription(results.getString("description"));
        return  park;
    }
}
