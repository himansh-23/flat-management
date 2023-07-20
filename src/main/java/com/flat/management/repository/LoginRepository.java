package com.flat.management.repository;

import com.flat.management.dao.LoginDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface LoginRepository extends CrudRepository<LoginDao,String> {

    @Modifying
    @Transactional
    @Query(value = "update login_details l set l.password= :password where l.apartment_id= :apartmentId" ,nativeQuery = true)
    void updateApartmentPassword(@Param("apartmentId")String apartmentId, @Param("password")String password);

    List<LoginDao> findAllByApartmentId(String apartmentId);
    Optional<LoginDao> findByApartmentIdAndUserId(String apartmentId, String userId);

}
