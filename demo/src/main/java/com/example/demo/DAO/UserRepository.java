package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DTO.User;


public interface UserRepository extends JpaRepository<User,Integer>{
    
    List<User> findAll();
    User save(User user);
    User findUserById(int userId);
    void deleteUserById(int userId);
    @Query("SELECT CASE WHEN COUNT(userName) > 0 THEN true ELSE false END FROM User WHERE userName = :userName AND password = :password")
    boolean existsByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
