package com.flat.management.dto;


import java.time.ZonedDateTime;


public class BuildingDetailsDTO {
    private String apartmentId;
    private String buildingId;
    private String nameOfBuilding;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private long noOfFlats;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastUpdatedAt;

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void setLastUpdatedAt(ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getNameOfBuilding() {
        return nameOfBuilding;
    }

    public void setNameOfBuilding(String nameOfBuilding) {
        this.nameOfBuilding = nameOfBuilding;
    }

    public long getNoOfFlats() {
        return noOfFlats;
    }

    public void setNoOfFlats(long noOfFlats) {
        this.noOfFlats = noOfFlats;
    }


}
