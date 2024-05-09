package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.UserDesignation;
import com.example.demo.DTO.UserType;

public interface UserTypeRepository extends JpaRepository<UserType,Long> {
    List<UserType> findAll();
    UserType save(UserType userType);
    UserType findUserTypeById(long id);
    UserType findByUserDesignation(UserDesignation userDesignation);
    
}
