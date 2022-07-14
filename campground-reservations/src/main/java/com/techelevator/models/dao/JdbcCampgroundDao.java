package com.techelevator.models.dao;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCampgroundDao implements CampgroundDao {

    JdbcTemplate jdbcTemplate;
    public JdbcCampgroundDao(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getAllCampgrounds() {
        List <Campground> campgrounds= new ArrayList<>();
        String sql = "SELECT campground_id " +
                "     , park_id " +
                "     , name " +
                "     , open_from_mm " +
                "     , open_to_mm  " +
                "     , daily_fee " +
                " FROM campground;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            campgrounds.add(mapRowToCampground(results));
        }
        return campgrounds;
    }



    @Override
    public Campground getCampgroundById(int campgroundId) {
        Campground myCampground = null;

        String sql = "SELECT campground_id " +
                "     , park_id " +
                "     , name " +
                "     , open_from_mm " +
                "     , open_to_mm  " +
                "     , daily_fee " +
                " FROM campground" +
                " WHERE campground_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundId);
        if (results.next()) {
            myCampground  = mapRowToCampground(results);
        }
        return myCampground;

    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground campground = new Campground();
        campground.setCampgroundId(results.getInt("campground_id"));
        campground.setParkId(results.getInt("park_id"));
        campground.setName(results.getString("name"));
        campground.setOpenFromMonth(results.getString("open_from_mm"));
        campground.setOpenToMonth(results.getString("open_to_mm"));
        campground.setDailyFee(results.getBigDecimal("daily_fee"));
        return  campground;

    }
}
