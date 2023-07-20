package com.flat.management.service.impl;

import com.flat.management.dto.OwnerDTO;
import com.flat.management.dto.RegisterDTO;
import com.flat.management.exceptions.InvalidLoginException;
import com.flat.management.service.ApartmentService;
import com.flat.management.service.LoginService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Inject
    private LoginService loginService;

    @Override
    public RegisterDTO addUserToApartment(OwnerDTO ownerDTO) throws InvalidLoginException {
        return loginService.addUserToApartment(ownerDTO);
    }
}
