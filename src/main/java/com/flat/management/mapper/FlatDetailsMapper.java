package com.flat.management.mapper;

import com.flat.management.dao.FlatDetails;
import com.flat.management.dto.FlatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlatDetailsMapper {

    FlatDetailsMapper INSTANCE = Mappers.getMapper(FlatDetailsMapper.class);

    FlatDetails mapFlatDTOToDao(FlatDTO flatDTO);
    FlatDTO  mapFlatDaoToDTO(FlatDetails flatDao);
}
