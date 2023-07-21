package com.flat.management.validator;

import com.flat.management.dto.*;
import org.springframework.util.Assert;

import java.util.Objects;

public class ObjectValidatorUtils {

    private ObjectValidatorUtils(){

    }
    public static Boolean registerValidator(RegisterDTO registerDTO){
        Assert.notNull(registerDTO.getApartmentName(),"Apartment Name should not be null.");
        Assert.notNull(registerDTO.getUserName(),"User Name should not be null.");
        Assert.notNull(registerDTO.getMobileNumber(),"Mobile Number should not be null.");
        Assert.notNull(registerDTO.getPassword(),"Password should not be null.");
        return true;
    }

    public static Boolean loginValidator(LoginDetailsDTO loginDetailsDTO){
        Assert.notNull(loginDetailsDTO.getApartmentId(),"Please enter apartmentId");
        Assert.notNull(loginDetailsDTO.getUserId(),"Please enter userId");
        Assert.notNull(loginDetailsDTO.getPassword(),"Please enter password.");
        return true;
    }

    public static Boolean addUserValidator(OwnerDTO ownerDTO){
        Assert.notNull(ownerDTO.getApartmentId(),"Please enter apartmentId");
        Assert.notNull(ownerDTO.getUserName(),"Please enter userName");
        Assert.notNull(ownerDTO.getPassword(),"Please enter password.");
        Assert.notNull(ownerDTO.getMobileNumber(),"Please enter Mobile Number.");
        return true;
    }

    public static Boolean addBuildingValidator(BuildingDetailsDTO buildingDetailsDTO){
        Assert.notNull(buildingDetailsDTO.getApartmentId(),"Please enter apartmentId");
        Assert.notNull(buildingDetailsDTO.getNameOfBuilding(),"Please enter buildingName");
        Assert.notNull(buildingDetailsDTO.getNoOfFlats(),"Please enter No of flats");
        return true;
    }

    public static Boolean addFlatValidator(FlatDTO flatDTO){
        Assert.notNull(flatDTO.getBuildingId(),"Please give buildingId");
        Assert.notNull(flatDTO.getFlatType(),"Please enter Flat Type");
        Assert.isTrue(flatDTO.getFlatNo()!= 0,"Please enter flat number/flat number should be >0");
        return true;
    }

    public static Boolean addTenantValidator(TenantDTO tenantDTO){
        Assert.notNull(tenantDTO.getTenantName(),"Please give Tenant Name");
        Assert.notNull(tenantDTO.getFlatId(),"Please enter Flat Id");
        Assert.notNull(tenantDTO.getRent(),"Please enter flat Rent");
        Assert.notNull(tenantDTO.getDeposit(),"Please give Deposit Amount");
        Assert.notNull(tenantDTO.getEntryDate(),"Please enter Entry Date");
        return true;
    }
}
