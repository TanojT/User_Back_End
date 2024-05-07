package com.example.demo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="address_line")
    private String addressLine;
    
    @Column(name="house_number")
    private String houseNumber;
    
    @Column(name="city")
    private String city;
    
    @Column(name="district")
    private String district;
    
    @Column(name="state")
    private String state;
    
    @Column(name="country")
    private String country;

    @Column(name="pincode")
    private String pinCode;
}
