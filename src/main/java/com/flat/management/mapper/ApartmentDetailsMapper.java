package com.flat.management.mapper;

import com.flat.management.dao.ApartmentDao;
import com.flat.management.dao.LoginDao;
import com.flat.management.dto.ApartmentDTO;
import com.flat.management.dto.OwnerDTO;
import com.flat.management.dto.RegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApartmentDetailsMapper {
    ApartmentDetailsMapper INSTANCE = Mappers.getMapper(ApartmentDetailsMapper.class);
    ApartmentDao mapRegisterDTOToApartmentDao(RegisterDTO registerDTO);
    RegisterDTO mapApartmentDaoToRegisterDTO(ApartmentDao apartmentDao);

    @Mapping(target = "password", ignore = true)
    @Mapping(source = "apartmentDao.apartmentId", target = "apartmentId")
    @Mapping(source = "apartmentDao.apartmentName", target = "apartmentName")
    RegisterDTO mapLoginDaoToRegisterDTO(LoginDao loginDao, ApartmentDao apartmentDao);

    @Mapping(target = "password", ignore = true)
    RegisterDTO mapOwnerDTOToRegisterDTO(LoginDao ownerDTO);

    ApartmentDTO mapRegisterApartmentDaoToDTO(ApartmentDao apartmentDao);

}
