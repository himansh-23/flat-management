package com.flat.management.service;

import com.flat.management.dto.OwnerDTO;
import com.flat.management.dto.RegisterDTO;
import com.flat.management.exceptions.InvalidLoginException;

public interface ApartmentService {
    RegisterDTO addUserToApartment(OwnerDTO ownerDTO) throws InvalidLoginException;
}
