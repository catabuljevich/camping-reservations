package com.techelevator.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campground {

    private int campgroundId;

    private int parkId;

    private String name;

    private String openFromMonth;

    private String openToMonth;

    private BigDecimal dailyFee;


    public Campground() {    }
    public Campground(int campgroundId, int parkId, String name, String openFromMonth, String openToMonth, BigDecimal dailyFee) {
        this.campgroundId = campgroundId;
        this.parkId = parkId;
        this.name = name;
        this.openFromMonth = openFromMonth;
        this.openToMonth = openToMonth;
        this.dailyFee = dailyFee;
    }

    public int getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(int campgroundId) {
        this.campgroundId = campgroundId;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenFromMonth() {
        return openFromMonth;
    }

    public void setOpenFromMonth(String openFromMonth) {
        this.openFromMonth = openFromMonth;
    }

    public String getOpenToMonth() {
        return openToMonth;
    }

    public void setOpenToMonth(String openToMonth) {
        this.openToMonth = openToMonth;
    }

    public BigDecimal getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(BigDecimal dailyFee) {
        this.dailyFee = dailyFee;
    }
}
