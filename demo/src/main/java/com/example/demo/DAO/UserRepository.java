package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.User;


public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findAll();
    User save(User user);
    User findUserById(int userId);
    void deleteUserById(int userId);
}
