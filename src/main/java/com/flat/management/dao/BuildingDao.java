package com.flat.management.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="building")
public class BuildingDao implements Serializable {

    @Id
    private String buildingId;
    private String nameOfBuilding;
    private String apartmentId;
    private String userId;
    private long noOfFlats;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastUpdatedAt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
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


    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
