package com.flat.management.service;

import com.flat.management.dto.FlatDTO;

import java.util.List;
import java.util.Optional;

public interface FlatService {

    Optional<FlatDTO> addFlatTOBuilding(FlatDTO flatDTO);

    List<FlatDTO> getAllFlatDetailsOfBuilding(String buildingId);

}
