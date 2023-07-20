package com.flat.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDTO {
    private String apartmentId;
    private String apartmentName;
    private String userName;
    private String mobileNumber;
    private String password;
}
