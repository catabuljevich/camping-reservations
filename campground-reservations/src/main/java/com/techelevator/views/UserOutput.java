package com.techelevator.views;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserOutput {


    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("                   Welcome to national Park Reservation System");
        System.out.println("**************************************************************************");
        System.out.println();
    }


    public static void invalidOption() {

        System.out.println("**** Invalid option! ***** ");
    }

    public static void displayParks(List<Park> allPArks) {
        System.out.println("**************************************************************************");
        System.out.println("                                  List Of Parks ");
        System.out.println("**************************************************************************");
        System.out.println();

        String header1 ="Park Number";
        String header2 ="Name";

        String totalHeader= String.format( "%s %16s ",header1,header2) ;
        System.out.println(totalHeader);
        for(Park park: allPArks)
        {
            String parkNumber =  "#"+ park.getParkId() + ") ";
            String parkName =  park.getName();
            String parkInfo= String.format( "%s %25s ",parkNumber,parkName) ;
            System.out.println(parkInfo);


        }

    }

    public static void displaySelectItems() {
        System.out.println("**************************************************************************");
        System.out.println("                   Select a ID Park for Further Details ");

      }


    public static void displayCampgrounds(List<Campground> allCampgrounds) {
        System.out.println("**************************************************************************");
        System.out.println("                                  List Of Campgrounds ");
        System.out.println("**************************************************************************");
        System.out.println();

        System.out.println("Park Campgrounds");
        System.out.println("");


        String header1 ="Campground Number";
        String header2 ="Name";
        String header3 ="Open";
        String header4 ="Close";
        String header5 ="Daily Fee";



        String totalHeader= String.format( "%s %16s %10s %10s %50s ",header1,header2,header3,header4,header5) ;
        System.out.println(totalHeader);
        for(Campground campground: allCampgrounds)
        {
            String campgroundNumber =  "#"+ campground.getCampgroundId() + ") ";
            String campgroundName =  campground.getName();
            String campgroundOpen =  campground.getOpenFromMonth();
            String campgroundClose =  campground.getOpenToMonth();
            BigDecimal campgroundFee = campground.getDailyFee();

            String numbertomonth1 = numberToMonth(campgroundOpen);


            String numbertomonth2 = numberToMonth(campgroundClose);


            String parkInfo= String.format( "%s %16s %10s %10s %50s ",campgroundNumber, campgroundName, numbertomonth1, numbertomonth2, campgroundFee) ;
            System.out.println(parkInfo);




        }
        System.out.println();

    }
    public static String numberToMonth(String month) {

        switch (month) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";


        }

        return month;
    }


    public static void selectCampground() {
        System.out.println("**************************************************************************");
        System.out.println("                   Select a ID Campground for Further Details ");

    }


}



