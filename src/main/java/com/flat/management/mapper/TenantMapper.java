package com.flat.management.mapper;

import com.flat.management.dao.FlatDetails;
import com.flat.management.dao.TenantDao;
import com.flat.management.dto.FlatDTO;
import com.flat.management.dto.TenantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TenantMapper {
    TenantMapper INSTANCE = Mappers.getMapper(TenantMapper.class);

    TenantDao mapTenantDTOToDao(TenantDTO tenantDTO);
    TenantDTO  mapTenantDaoToDTO(TenantDao flatDao);
}
