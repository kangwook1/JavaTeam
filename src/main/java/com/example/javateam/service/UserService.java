package com.example.javateam.service;

import com.example.javateam.domain.UserDao;
import com.example.javateam.dto.user.UserLoginReq;
import com.example.javateam.dto.user.UserSignUpReq;
import com.example.javateam.exception.CustomException;
import com.example.javateam.exception.ErrorCode;
import com.example.javateam.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Long signup(UserSignUpReq reqDto){
        if(checkEmailDuplicated(reqDto.getEmail())){
            throw new CustomException(ErrorCode.DUPLICATED_EMAIL);
        }
        UserDao userDao=reqDto.toEntity();
        userDao.passwordEncode(passwordEncoder);
        userDao.addUserAuthority();
        userRepo.save(userDao);
        return userDao.getId();
    }
    public boolean checkEmailDuplicated(String email){
        return userRepo.existsByEmail(email);
    }
}
