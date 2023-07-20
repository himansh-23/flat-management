package com.flat.management.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class OwnerDTO {
    private String apartmentId;
    private ZonedDateTime createdAt;
    private String userName;
    private String mobileNumber;
    private String password;
}
