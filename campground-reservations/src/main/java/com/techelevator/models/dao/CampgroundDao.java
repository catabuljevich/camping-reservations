package com.techelevator.models.dao;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;

import java.time.LocalDate;
import java.util.List;

public interface CampgroundDao {

    List<Campground> getAllCampgrounds();

    Campground getCampgroundById(int campgroundId);


}
