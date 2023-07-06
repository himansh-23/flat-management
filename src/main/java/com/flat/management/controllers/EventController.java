package com.flat.management.controllers;

import com.flat.management.dto.BuildingDetails;
import com.flat.management.dto.NewBuildingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {


    @PostMapping("/add/building")
    public void addBuildingEvent(@RequestBody NewBuildingDTO newBuildingDTO){

    }

    @GetMapping("/get/building/details")
    public BuildingDetails addBuildingEvent(){

        return new BuildingDetails();
    }
}
