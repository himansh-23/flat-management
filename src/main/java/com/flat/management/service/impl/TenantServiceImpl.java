package com.flat.management.service.impl;

import com.flat.management.dao.TenantDao;
import com.flat.management.dto.TenantDTO;
import com.flat.management.mapper.TenantMapper;
import com.flat.management.repository.TenantRepository;
import com.flat.management.service.TenantService;
import com.flat.management.validator.ObjectValidatorUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TenantServiceImpl implements TenantService {

    @Inject
    private TenantRepository tenantRepository;

    public TenantDTO addTenant(TenantDTO tenantDTO){
        ObjectValidatorUtils.addTenantValidator(tenantDTO);
        TenantMapper i = TenantMapper.INSTANCE;
        TenantDao d = i.mapTenantDTOToDao(tenantDTO);
        d.setTenantId(UUID.randomUUID().toString());
        ZonedDateTime time = ZonedDateTime.now();
        d.setActive(true);
        d.setCreatedAt(time);
        return Optional.of(tenantRepository.save(d)).map(value -> i.mapTenantDaoToDTO(value)).orElse(null);
    }
}
