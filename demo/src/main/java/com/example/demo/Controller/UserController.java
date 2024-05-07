package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.AddressRepository;
import com.example.demo.DTO.Address;
import com.example.demo.DTO.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    

    @GetMapping
    public List<User> getAllUser(){
        return userService.findAll();
    }

    UserController() {
        System.out.println("User Controller ---------------------------->");
    }

    @GetMapping(path="/health")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<String>("User Health is good", HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> putUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted user successfully!");
    }

}
