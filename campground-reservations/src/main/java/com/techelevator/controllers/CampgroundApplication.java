package com.techelevator.controllers;

import com.techelevator.models.dao.*;
import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;
import com.techelevator.views.UserOutput;
import com.techelevator.views.UserInput;

import javax.sql.DataSource;
import java.util.List;

import static com.techelevator.views.UserInput.displayParkDetail;
import static com.techelevator.views.UserOutput.displayCampgrounds;


public class CampgroundApplication {

    private ParkDao parkDao;
    private CampgroundDao campgroundDao;
    private SiteDao siteDao;
    private ReservationDao reservationDao;

    public CampgroundApplication(DataSource datasource) {
        // create your DAOs here
        parkDao = new JdbcParkDao(datasource);
        campgroundDao = new JdbcCampgroundDao(datasource);
        siteDao = new JdbcSiteDao(datasource);
        reservationDao = new JdbcReservationDao(datasource);

    }

    public void run() {
        boolean executeAplication = true;
        while (executeAplication) {
            // todo: display home screen
            UserOutput.displayHomeScreen();

            // todo: and get user choice
            String userChoice = UserInput.getHomeScreenSelection();


            if (userChoice.equalsIgnoreCase("list")) {
                // todo: logic to display all vending machine items
                displayParks(parkDao.getAllParks());


            } else if (userChoice.equalsIgnoreCase("reserve")) {
                // todo: logic reserve
                selectPark();
                displayParks(parkDao.getAllParks());

                String parkChoise = UserInput.getParkSelection();
                Park park = parkDao.getParkById(Integer.parseInt(parkChoise));
                displayParkDetail(park);

                String menuChoise = UserInput.getMenuChoise();
                if (menuChoise.equalsIgnoreCase("list of Campgrounds")) {
                    displayCampgrounds(campgroundDao.getAllCampgrounds());

                } else if (menuChoise.equalsIgnoreCase("Search for Reservation")) {
                    selectCampground();
                    displayCampgrounds(campgroundDao.getAllCampgrounds());

                   // String campgroudChoise = UserInput.getCampSelection();
                    //Campground campground = campgroundDao.getCampgroundById(Integer.parseInt(campgroudChoise));
                    //displayCampgroundsDetails(campground);
                }

            } else if (userChoice.equalsIgnoreCase("invalid")) {
                // todo:
                UserOutput.invalidOption();
                UserOutput.displayHomeScreen();
                userChoice = UserInput.getHomeScreenSelection();

            } else if (userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application
                executeAplication = false;
                break;
            }


        }


    }

    private void selectCampground() {
        UserOutput.selectCampground();
    }

    private void selectPark() {
        UserOutput.displaySelectItems();
    }

    private void displayParks(List<Park> allParks) {
        UserOutput.displayParks(allParks);
    }

    private void displayCampgrounds(List<Campground> allCampgrounds) {
        UserOutput.displayCampgrounds(allCampgrounds);
    }
}
