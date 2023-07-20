package com.flat.management.dto;

import lombok.Builder;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Builder
public class ApartmentDTO {
    private String apartmentId;
    private String apartmentName;
    private int noOfBuilding;
    private ZonedDateTime createdAt;
}
