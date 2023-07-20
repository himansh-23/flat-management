package com.flat.management.repository;

import com.flat.management.dao.ApartmentDao;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<ApartmentDao,String> {

    ApartmentDao findByApartmentName(String name);
}
