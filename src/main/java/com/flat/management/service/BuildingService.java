package com.flat.management.service;

import com.flat.management.dto.BuildingDetailsDTO;
import com.flat.management.exceptions.NullValueExceptions;

import java.util.List;
import java.util.Optional;

public interface BuildingService {
    Optional<BuildingDetailsDTO> createNewBuilding(BuildingDetailsDTO buildingDetailsDTO) throws NullValueExceptions;
    Optional<BuildingDetailsDTO> getBuildingDetails(String buildingId);

    List<BuildingDetailsDTO> getAllBuildingForApartment(String apartmentId);
}
