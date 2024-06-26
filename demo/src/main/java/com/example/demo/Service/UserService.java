package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AddressRepository;
import com.example.demo.DAO.UserRepository;
import com.example.demo.DAO.UserTypeRepository;
import com.example.demo.DTO.Address;
import com.example.demo.DTO.User;
import com.example.demo.DTO.UserType;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    
    @Autowired
    private  UserTypeRepository userTypeRepository;

    public User save(User user){
         Address address = user.getAddress();
        if (address != null && address.getId() != null) {
            Address managedAddress = addressRepository.findById(address.getId());
            user.setAddress(managedAddress);
        }
        UserType userType = user.getUserType();
        if(userType != null && userType.getId() == null) {
            userType = userTypeRepository.save(userType);
        }
        user.setUserType(userType);
        
        return userRepository.save(user);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        User persistentUser = userRepository.findUserById(Integer.parseInt(user.getId()+""));
        if (persistentUser != null) {
            persistentUser.setFirstName(user.getFirstName());
            persistentUser.setLastName(user.getLastName());
            persistentUser.setMobile(user.getMobile());
            persistentUser.setEmailId(user.getEmailId());
            persistentUser.setAddress(user.getAddress());
            return userRepository.save(persistentUser);
        } else {
            // Handle not found case
            return null;
        }
    }
    public void delete(int userId){
        userRepository.deleteUserById(userId);
        
    }

}
