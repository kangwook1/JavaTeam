package com.example.javateam.repository;

import com.example.javateam.domain.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDao,Long> {
    Optional<UserDao> findByEmail(String email);
}
