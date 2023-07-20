package com.flat.management.service;

import com.flat.management.dto.*;
import com.flat.management.exceptions.InvalidLoginException;

import java.util.Optional;

public interface LoginService {

    RegisterDTO register(RegisterDTO registerDTO);

    RegisterDTO addUserToApartment(OwnerDTO ownerDTO) throws InvalidLoginException;

    ApartmentDTO login(LoginDetailsDTO loginDetailsDTO) throws InvalidLoginException;

    void updatePassword(LoginUpdateDTO loginUpdateDTO) throws InvalidLoginException;
}
