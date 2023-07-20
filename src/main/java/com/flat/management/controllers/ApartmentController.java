package com.flat.management.controllers;

import com.flat.management.dto.BuildingDetailsDTO;
import com.flat.management.dto.ErrorResponse;
import com.flat.management.dto.OwnerDTO;
import com.flat.management.exceptions.InvalidLoginException;
import com.flat.management.exceptions.NullValueExceptions;
import com.flat.management.service.ApartmentService;
import com.flat.management.service.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@CrossOrigin("*")
@Slf4j
public class ApartmentController {

    @Inject
    private ApartmentService apartmentService;
    @PostMapping("/add/user/apartment")
    public ResponseEntity<?> appUserToApartment(@RequestBody OwnerDTO ownerDTO) {
        try{
            return ResponseEntity.accepted().body(apartmentService.addUserToApartment(ownerDTO));
        }catch (InvalidLoginException e){
            return ResponseEntity.badRequest().header("X-Error",e.getMsg()).build();
        } catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
        }
    }
}
