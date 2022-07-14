package com.techelevator.models.dao;

import com.techelevator.models.dto.Park;
import com.techelevator.models.dto.Site;

import java.time.LocalDate;
import java.util.List;

public interface SiteDao {

    List<Site> getAllSites();

    Site getSiteById(int siteId);


    List<Site> getAvailableSites(String campgroundChoise, LocalDate entryDate, LocalDate exitDate);
}
