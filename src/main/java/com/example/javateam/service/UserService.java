package com.example.javateam.service;

import com.example.javateam.domain.UserDao;
import com.example.javateam.dto.user.UserSignUpReq;
import com.example.javateam.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    //private final PasswordEncoder passwordEncoder;

    public Long signup(UserSignUpReq reqDto){
        if(userRepo.findByEmail(reqDto.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 가입된 유저입니다.");
        }
        UserDao userDao=reqDto.toEntity();
        userRepo.save(userDao);
        return userDao.getId();
    }

   /* public Long login(UserLoginReq reqDto){

    }*/
}
