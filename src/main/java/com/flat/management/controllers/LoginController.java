package com.flat.management.controllers;

import com.flat.management.configuration.SecurityTokenManager;
import com.flat.management.dto.*;
import com.flat.management.exceptions.InvalidLoginException;
import com.flat.management.exceptions.NullValueExceptions;
import com.flat.management.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@Slf4j
public class LoginController {

    @Inject
    private LoginService loginService;

    @Inject
    SecurityTokenManager securityTokenManager;

    @PostMapping("/apartment/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO registerDTO) throws NullValueExceptions {
     try{
        return ResponseEntity.ok(loginService.register(registerDTO));
    }catch (Exception e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
    }
    }

    @PostMapping("/apartment/login")
    public ResponseEntity<?> loginApartment(@RequestBody LoginDetailsDTO loginDetailsDTO) {
        try {
            ApartmentDTO apartmentDTO = loginService.login(loginDetailsDTO);
            return ResponseEntity.ok().header("Authorization", securityTokenManager.generateToken(loginDetailsDTO.getUserId())).body(loginService.login(loginDetailsDTO));
        } catch (InvalidLoginException e){
            return ResponseEntity.badRequest().header("X-error",e.getMsg()).build();
        } catch (Exception e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
    }
    }

    @PatchMapping("/apartment/password/update")
    public ResponseEntity<?> addBuildingEvent(@RequestBody LoginUpdateDTO loginUpdateDTO) {
        try {
            loginService.updatePassword(loginUpdateDTO);
            return ResponseEntity.ok().build();
        }catch (InvalidLoginException e){
                return ResponseEntity.badRequest().body(ErrorResponse.builder().errorMsg(e.getMsg()).build());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
        }
    }
}
