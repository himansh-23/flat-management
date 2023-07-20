package com.flat.management.dto;

import lombok.Data;

@Data
public class LoginUpdateDTO {

    private String apartmentId;
    private String userId;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;


}
