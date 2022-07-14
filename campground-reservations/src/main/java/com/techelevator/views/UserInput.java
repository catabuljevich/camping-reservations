package com.techelevator.views;

import com.techelevator.models.dto.Campground;
import com.techelevator.models.dto.Park;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInput
{
    private static Scanner in = new Scanner(System.in);

    public static void setIn(InputStream inStream)
    {
        in = new Scanner(inStream);
    }

    public static String getHomeScreenSelection(){

        System.out.println();
        System.out.println("What do you want to do? ");
        System.out.println("1) List Parks");
        System.out.println("2) Make Reservation");
        System.out.println("3) Exit");
        System.out.println();
        System.out.print("Please make a selection: ");
        String choice = in.nextLine().trim().toLowerCase();

        switch (choice) {
            case "1":
                return "list";
            case "2":
                return "reserve";
            case "3":
                return "exit";
            default:
                return "invalid";
        }

    }

    public static void displayParkDetail(Park park)
    {
        System.out.println("Park Information Screen");
        System.out.println(park.getName() + " National Park");
        System.out.println("Location: " + park.getLocation());
        System.out.println("Established: " + park.getDate() + " sq km");
        System.out.println("Area: " + park.getArea());
        System.out.println("Annual Visitors: " + park.getVisitors());
        System.out.println();
        System.out.println(park.getDescription());
    }


    public static String getParkSelection() {
        String choice = in.nextLine().trim().toLowerCase();
        return choice;
    }

    public static String getMenuChoise() {
        System.out.println();
        System.out.println("Select a Command:  ");
        System.out.println("1)  View Campgrounds");
        System.out.println("2) Search for Reservation");
        System.out.println("3) Return to Previous Screen");
        System.out.println();
        System.out.print("Please make a selection: ");

        String choice = in.nextLine().trim().toLowerCase();

        switch (choice) {
            case "1":
                return "list of Campgrounds";
            case "2":
                return "reserve Campground";
            case "3":
                return "exit";
            default:
                return "invalid";
        }

    }

    public static void displayCampgroundsDetails(Campground campground)
    {
        System.out.println("Park Campgrounds");
        System.out.println(campground.getName() + " National Park");
        System.out.println("Location: " + cam.getLocation());
        System.out.println("Established: " + park.getDate() + " sq km");
        System.out.println("Area: " + park.getArea());
        System.out.println("Annual Visitors: " + park.getVisitors());
        System.out.println();
        System.out.println(park.getDescription());
    }



    public static String getCampSelection() {
        System.out.println("Which campground (enter 0 to cancel)?");
        String choice = in.nextLine().trim().toLowerCase();
        return choice;
    }

    public static LocalDate getEntryDate() {
        System.out.println("What is the arrival date?");
        System.out.println("yyyy-MM-dd");
        String choice = in.nextLine().trim().toLowerCase();
        return LocalDate.parse(choice);
    }

    public static LocalDate getExitDate() {
        System.out.println("What is the departure date?");
        System.out.println("yyyy-MM-dd");
        String choice = in.nextLine().trim().toLowerCase();
        return LocalDate.parse(choice);
    }
}
