package com.flat.management.dto;

import javax.persistence.Id;
import java.time.ZonedDateTime;

public class FlatDTO {
    private String flatId;
    private String buildingId;
    private int flatNo;

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    private String flatType;

    public int getFlatNo() {
        return flatNo;
    }

    private ZonedDateTime createdAt;


    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFlatId() {
        return flatId;
    }

    public void setFlatId(String flatId) {
        this.flatId = flatId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }
}
