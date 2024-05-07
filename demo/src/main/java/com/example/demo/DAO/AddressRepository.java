package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.DTO.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
    List<Address> findAll();
    Address save(Address address);
    Address findById(long id);
}
