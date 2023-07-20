package com.flat.management.mapper;

import com.flat.management.dao.BuildingDao;
import com.flat.management.dto.BuildingDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuildingDetailsMapper {

    BuildingDetailsMapper INSTANCE = Mappers.getMapper(BuildingDetailsMapper.class);


    BuildingDao  mapBuildingDTOToDao(BuildingDetailsDTO buildingDetailsDTO);
    BuildingDetailsDTO  mapBuildingDaoToDTO(BuildingDao buildingDao);
}
