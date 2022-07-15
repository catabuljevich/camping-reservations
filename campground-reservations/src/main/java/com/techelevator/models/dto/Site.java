package com.techelevator.models.dto;

import java.math.BigDecimal;

public class Site {

    private int siteId;

    private int campgroundId;

    private int siteNumber;

    private int maxOccupancy;

    private boolean accessible;

    private  int maxRvLength;

    private boolean utilities;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    private BigDecimal fee;

    public Site() {
    }

    public Site(int siteId, int campgroundId, int siteNumber, int maxOccupancy, boolean accessible, int maxRvLength, boolean utilities, BigDecimal fee) {
        this.siteId = siteId;
        this.campgroundId = campgroundId;
        this.siteNumber = siteNumber;
        this.maxOccupancy = maxOccupancy;
        this.accessible = accessible;
        this.maxRvLength = maxRvLength;
        this.utilities = utilities;
        this.fee = fee;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(int campgroundId) {
        this.campgroundId = campgroundId;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public int getMaxRvLength() {
        return maxRvLength;
    }

    public void setMaxRvLength(int maxRvLength) {
        this.maxRvLength = maxRvLength;
    }

    public boolean isUtilities() {
        return utilities;
    }

    public void setUtilities(boolean utilities) {
        this.utilities = utilities;
    }
}
