package com.flat.management.controllers;

import com.flat.management.dto.FlatDTO;
import com.flat.management.dto.TenantDTO;
import com.flat.management.service.FlatService;
import com.flat.management.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@CrossOrigin(origins="*")
@Slf4j
public class TenantController {

    @Inject
    private TenantService tenantService;
    @PostMapping("/add/tenant")
    public ResponseEntity<TenantDTO> addFlat(@RequestBody TenantDTO tenantDTO){
     try{
        return ResponseEntity.ok(tenantService.addTenant(tenantDTO));
    }catch (Exception e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
    }
    }
}
