package com.flat.management.repository;

import com.flat.management.dao.TenantDao;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<TenantDao,String> {
}
