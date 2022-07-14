package com.techelevator.views;

import com.techelevator.models.dto.Park;

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

        int number = 1;
        String header1 ="Park Number";
        String header2 ="Name";

        String totalHeader= String.format( "%s %16s ",header1,header2) ;
        System.out.println(totalHeader);
        for(Park park: allPArks)
        {
            String parkNumber =  "#"+number + ") ";
            String parkName =  park.getName();
            String parkInfo= String.format( "%s %25s ",parkNumber,parkName) ;
            System.out.println(parkInfo);

            number++;

        }
        System.out.println();

    }

    public static void displaySelectItems() {
        System.out.println("**************************************************************************");
        System.out.println("                   Select a Park for Further Details ");

      }
}
