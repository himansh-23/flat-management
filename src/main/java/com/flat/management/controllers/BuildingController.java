package com.flat.management.controllers;

import com.flat.management.dto.BuildingDetailsDTO;
import com.flat.management.exceptions.NullValueExceptions;
import com.flat.management.service.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@Slf4j
public class BuildingController {

    @Inject
    private BuildingService buildingService;


    @PostMapping("/add/building")
    public ResponseEntity<BuildingDetailsDTO> addBuildingEvent(@RequestBody BuildingDetailsDTO buildingDetailsDTO) throws NullValueExceptions {
        try{
            return ResponseEntity.ok(buildingService.createNewBuilding(buildingDetailsDTO).orElse(new BuildingDetailsDTO()));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
        }
    }

    @GetMapping("/get/building/details/{apartmentId}")
    public ResponseEntity<List<BuildingDetailsDTO>> getBuildingEvent(@PathVariable("apartmentId")String apartmentId){
        return ResponseEntity.ok(buildingService.getAllBuildingForApartment(apartmentId));
    }
}
