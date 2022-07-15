package com.techelevator.models.dao;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao{

    JdbcTemplate jdbcTemplate;
    public JdbcSiteDao(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getAllSites() {

        List <Site> sites= new ArrayList<>();
        String sql = "SELECT site_id " +
                "     , campground_id " +
                "     , site_number " +
                "     , max_occupancy " +
                "     , accessible " +
                "     , max_rv_length " +
                "     , utilities " +
                " FROM site;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            sites.add(mapRowToSite(results));
        }
        return sites;
    }


    @Override
    public Site getSiteById(int siteId) {
        Site mySite = null;

        String sql = "SELECT site_id " +
                "     , campground_id " +
                "     , site_number " +
                "     , max_occupancy " +
                "     , accessible " +
                "     , max_rv_length " +
                "     , utilities " +
                " FROM site " +
                " WHERE site_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, siteId);
        if (results.next()) {
            mySite  = mapRowToSite(results);
        }
        return mySite;

    }

    @Override
    public List<Site> getAvailableSites(String campgroundChoise, LocalDate entryDate, LocalDate exitDate) {
        List <Site> sites= new ArrayList<>();
        String sql = "SELECT site_id\n" +
                "     , s.campground_id\n" +
                "     , site_number\n" +
                "     , max_occupancy\n" +
                "     , accessible\n" +
                "     , max_rv_length\n" +
                "     , utilities\n" +
                "FROM site AS s\n" +
                "         INNER JOIN campground c\n" +
                "                    on c.campground_id = s.campground_id\n" +
                "WHERE s.campground_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundChoise , entryDate, exitDate);
        while (results.next()) {
            sites.add(mapRowToSite(results));
        }
        return sites;

    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return  site;
    }
}
