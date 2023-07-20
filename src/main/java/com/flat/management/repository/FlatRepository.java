package com.flat.management.repository;

import com.flat.management.dao.FlatDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlatRepository extends JpaRepository<FlatDetails,String> {
    List<FlatDetails> getAllByBuildingId(String buildingID);
}
