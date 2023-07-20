package com.flat.management.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="apartment_details")
@Data
public class ApartmentDao {
    @Id
    private String apartmentId;
    private String apartmentName;
    private int noOfBuilding;
    private ZonedDateTime createdAt;
}
