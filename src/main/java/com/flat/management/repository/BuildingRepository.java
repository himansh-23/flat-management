package com.flat.management.repository;

import com.flat.management.dao.BuildingDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingDao,String> {

    List<BuildingDao> findAllByApartmentId(String apartmentId);

}
