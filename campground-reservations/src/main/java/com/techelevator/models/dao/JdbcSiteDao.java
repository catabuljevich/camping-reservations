package com.techelevator.models.dao;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao{

    JdbcTemplate jdbcTemplate;
    public JdbcSiteDao(DataSource dataSource)
    {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    public List<Site> getAvailableSites(int campgroundChoise, int monthFrom, int monthTo, LocalDate entryDate, LocalDate exitDate) {
        List <Site> sites= new ArrayList<>();
        String sql = "SELECT s.site_id, site_number , max_occupancy , max_rv_length , utilities,accessible,  cast(daily_fee as varchar(15)) as daily_fee \n" +
                "FROM site AS s\n" +
                "INNER JOIN campground AS c\n" +
                "    on s.campground_id = c.campground_id\n" +
                "WHERE c.campground_id = ?\n" +
                "AND cast(c.open_from_mm as INT) <= ?\n" +
                "AND cast(c.open_to_mm as INT ) >= ?\n" +
                "AND site_id NOT IN (Select Distinct s.site_id\n" +
                "                    FROM site AS s\n" +
                "                    INNER JOIN  reservation  r\n" +
                "                    ON s.site_id = r.site_id\n" +
                "                    WHERE s.campground_id = ?\n" +
                "                    AND ((from_date < ? and to_date >= ?  )\n" +
                "                        or (from_date > ? AND from_date < ?)));";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundChoise , monthFrom, monthTo, campgroundChoise, entryDate, exitDate, exitDate, exitDate );
        while (results.next()) {
            sites.add(mapRowToSite(results));
        }
        return sites;

    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        if(results.getString("daily_fee") != null){
            String fee = results.getString("daily_fee").replace("$ ", "").replace(",",".");
            site.setFee(new BigDecimal(fee));

        }

        return  site;
    }
}
