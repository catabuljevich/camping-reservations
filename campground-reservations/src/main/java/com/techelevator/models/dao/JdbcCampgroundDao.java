package com.techelevator.models.dao;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcCampgroundDao implements CampgroundDao {

    JdbcTemplate jdbcTemplate;
    public JdbcCampgroundDao(DataSource dataSource)
    {
       this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getAllCampgrounds() {
        List <Campground> campgrounds= new ArrayList<>();
        String sql = "SELECT campground_id " +
                "     , park_id " +
                "     , campground.name " +
                "     , open_from_mm " +
                "     , open_to_mm  " +
                "     , cast(daily_fee as varchar(15)) as daily_fee " +
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

    private static Campground mapRowToCampground(SqlRowSet results) {
        Campground campground = new Campground();
        campground.setCampgroundId(results.getInt("campground_id"));
        campground.setParkId(results.getInt("park_id"));
        campground.setName(results.getString("name"));
        campground.setOpenFromMonth(results.getString("open_from_mm"));
        campground.setOpenToMonth(results.getString("open_to_mm"));

        String fee = results.getString("daily_fee").replace("$ ", "").replace(",",".");
        campground.setDailyFee(new BigDecimal(fee));

        return  campground;

    }
}
