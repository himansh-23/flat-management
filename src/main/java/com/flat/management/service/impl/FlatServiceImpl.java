package com.flat.management.service.impl;


import com.flat.management.dao.FlatDetails;
import com.flat.management.dto.FlatDTO;
import com.flat.management.mapper.FlatDetailsMapper;
import com.flat.management.repository.FlatRepository;
import com.flat.management.service.FlatService;
import com.flat.management.validator.ObjectValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlatServiceImpl implements FlatService {

    @Inject
    private FlatRepository flatRepository;

    @Override
    public Optional<FlatDTO> addFlatTOBuilding(FlatDTO flatDTO) {
        ObjectValidatorUtils.addFlatValidator(flatDTO);
        FlatDetails f = FlatDetailsMapper.INSTANCE.mapFlatDTOToDao(flatDTO);
        f.setFlatId(UUID.randomUUID().toString());
        f.setCreatedAt(ZonedDateTime.now());
        log.info("Flat details dto {}",f);
        return Optional.ofNullable(flatRepository.save(f)).map(value -> FlatDetailsMapper.INSTANCE.mapFlatDaoToDTO(value));

    }

    @Override
    public List<FlatDTO> getAllFlatDetailsOfBuilding(String buildingId){
        FlatDetailsMapper f = FlatDetailsMapper.INSTANCE;
     return flatRepository.getAllByBuildingId(buildingId).stream().map(value -> f.mapFlatDaoToDTO(value))
             .collect(Collectors.toList());
    }
}
