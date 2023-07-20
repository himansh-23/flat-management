package com.flat.management.controllers;

import com.flat.management.dto.FlatDTO;
import com.flat.management.service.FlatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@Slf4j
public class FlatController {

    @Inject
    private FlatService flatService;
    @PostMapping("/add/flat")
    public ResponseEntity<FlatDTO> addFlat(@RequestBody FlatDTO flatDTO){
        try {
            return ResponseEntity.ok(flatService.addFlatTOBuilding(flatDTO).orElse(new FlatDTO()));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
        }
    }

    @GetMapping("/all/{buildingId}/flat")
    public ResponseEntity<List<FlatDTO>> getAllFlatDetailsOfFlat(@PathVariable String buildingId){
        try{
             return ResponseEntity.ok(flatService.getAllFlatDetailsOfBuilding(buildingId));
        } catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().header("X-error",e.getMessage()).build();
        }
    }
}
