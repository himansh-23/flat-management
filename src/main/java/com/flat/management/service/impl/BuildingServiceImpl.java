package com.flat.management.service.impl;

import com.flat.management.dao.BuildingDao;
import com.flat.management.dto.BuildingDetailsDTO;
import com.flat.management.exceptions.NullValueExceptions;
import com.flat.management.mapper.BuildingDetailsMapper;
import com.flat.management.repository.BuildingRepository;
import com.flat.management.service.BuildingService;
import com.flat.management.validator.ObjectValidatorUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Inject
    private BuildingRepository buildingRepository;


    public Optional<BuildingDetailsDTO> createNewBuilding(BuildingDetailsDTO buildingDetailsDTO) throws NullValueExceptions {

        ObjectValidatorUtils.addBuildingValidator(buildingDetailsDTO);
        if(Objects.isNull(buildingDetailsDTO.getNameOfBuilding())){
            throw new NullValueExceptions("Name of Building", "BuildingDetailsDTO");
        }
        BuildingDao buildingDao = BuildingDetailsMapper.INSTANCE.mapBuildingDTOToDao(buildingDetailsDTO);
        buildingDao.setBuildingId(UUID.randomUUID().toString());
        ZonedDateTime currentTime = ZonedDateTime.now();
        buildingDao.setCreatedDate(currentTime);
        buildingDao.setLastUpdatedAt(currentTime);
        return Optional.ofNullable(buildingRepository.save(buildingDao)).map(value -> BuildingDetailsMapper.INSTANCE.mapBuildingDaoToDTO(value));

    }

    public Optional<BuildingDetailsDTO> getBuildingDetails(String buildingId){
        return buildingRepository.findById(buildingId).map(value -> BuildingDetailsMapper.INSTANCE.mapBuildingDaoToDTO(value));
    }

    public List<BuildingDetailsDTO> getAllBuildingForApartment(String apartmentId){
        return buildingRepository.findAllByApartmentId(apartmentId).stream().map(value -> BuildingDetailsMapper.INSTANCE.mapBuildingDaoToDTO(value))
                .collect(Collectors.toList());
    }
}
