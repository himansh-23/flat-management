package com.flat.management.service.impl;

import com.flat.management.dao.ApartmentDao;
import com.flat.management.dao.LoginDao;
import com.flat.management.dto.*;
import com.flat.management.exceptions.InvalidLoginException;
import com.flat.management.mapper.ApartmentDetailsMapper;
import com.flat.management.repository.LoginRepository;
import com.flat.management.repository.ApartmentRepository;
import com.flat.management.service.LoginService;
import com.flat.management.util.Utility;
import com.flat.management.validator.ObjectValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private LoginRepository loginRepository;
    @Inject
    private ApartmentRepository apartmentRepository;
    @Override
    public RegisterDTO register(RegisterDTO registerDTO) {

            ObjectValidatorUtils.registerValidator(registerDTO);
            ApartmentDetailsMapper apartmentDetailsMapper = ApartmentDetailsMapper.INSTANCE;
            ApartmentDao apartmentDao = apartmentDetailsMapper.mapRegisterDTOToApartmentDao(registerDTO);
            ZonedDateTime time = ZonedDateTime.now();
            apartmentDao.setApartmentId(UUID.randomUUID().toString());
            apartmentDao.setCreatedAt(time);
            String userId = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
            Optional<ApartmentDao> apartmentDao1 = Optional.of(apartmentRepository.save(apartmentDao));
            return apartmentDao1.map(
                    value -> {
                        LoginDao l = LoginDao.builder()
                                .apartmentId(value.getApartmentId())
                                .docId(UUID.randomUUID().toString())
                                .userId(userId)
                                .userName(registerDTO.getUserName())
                                .mobileNumber(registerDTO.getMobileNumber())
                                .createdAt(time)
                                .password(passwordEncoder.encode(registerDTO.getPassword()))
                                .build();
                        loginRepository.save(l);
                        return l;
                    }
            ).map(value -> apartmentDetailsMapper.mapLoginDaoToRegisterDTO(value, apartmentDao1.get())).orElse(null);
    }

    @Override
    public RegisterDTO addUserToApartment(OwnerDTO ownerDTO) throws InvalidLoginException{
        ObjectValidatorUtils.addUserValidator(ownerDTO);
        List<LoginDao> loginDao = loginRepository.findAllByApartmentId(ownerDTO.getApartmentId());
        if(!loginDao.isEmpty()) {
            String userId = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
            List<String> userIds = Utility.createUserIds();
            List<String> existanceUserId = loginDao.stream().map(value -> value.getUserId()).collect(Collectors.toList());
            userIds = userIds.stream().filter(value -> !existanceUserId.contains(value)).collect(Collectors.toList());
                ZonedDateTime now = ZonedDateTime.now();
                LoginDao l = LoginDao.builder()
                        .userId(userIds.stream().findFirst().get())
                        .userName(ownerDTO.getUserName())
                        .apartmentId(ownerDTO.getApartmentId())
                        .createdAt(now)
                        .mobileNumber(ownerDTO.getMobileNumber())
                        .password(passwordEncoder.encode(ownerDTO.getPassword())).build();
            loginRepository.save(l);
            return ApartmentDetailsMapper.INSTANCE.mapOwnerDTOToRegisterDTO(l);
            }
        throw new InvalidLoginException("No Apartment Found with this apartmentId");
        }

    @Override
    public ApartmentDTO login(LoginDetailsDTO loginDetailsDTO) throws InvalidLoginException {
        ObjectValidatorUtils.loginValidator(loginDetailsDTO);
        log.info(loginDetailsDTO.getApartmentId());
        List<LoginDao> loginDao = loginRepository.findAllByApartmentId(loginDetailsDTO.getApartmentId());
        Optional<LoginDao> result =loginDao.stream().filter(value -> value.getUserId().equals(loginDetailsDTO.getUserId())).findAny()
                .filter(value -> passwordEncoder.matches(loginDetailsDTO.getPassword(), value.getPassword()));
        return result.flatMap(value -> apartmentRepository.findById(loginDetailsDTO.getApartmentId()))
                .map(value -> ApartmentDetailsMapper.INSTANCE.mapRegisterApartmentDaoToDTO(value)).orElseThrow(()-> new InvalidLoginException("UserNot Found/Password Incorrect."));
    }

    @Override
    public void updatePassword(LoginUpdateDTO loginUpdateDTO) throws InvalidLoginException{

        Optional<LoginDao> loginDao = loginRepository.findByApartmentIdAndUserId(loginUpdateDTO.getApartmentId(), loginUpdateDTO.getUserId());
        if(loginDao.isPresent()){
            if (passwordEncoder.matches(loginUpdateDTO.getOldPassword(), loginDao.get().getPassword())) {

                if (loginUpdateDTO.getNewPassword().equals(loginUpdateDTO.getConfirmPassword())) {
                    loginRepository.updateApartmentPassword(loginUpdateDTO.getApartmentId(), passwordEncoder.encode(loginUpdateDTO.getNewPassword()));
                } else {
                    throw new InvalidLoginException("Confirm Password not matched.");
                }
            } else {
                throw new InvalidLoginException("Please enter correct old password.");
            }}else{
            throw new InvalidLoginException("Apartment Not Present");
        }

    }

}
