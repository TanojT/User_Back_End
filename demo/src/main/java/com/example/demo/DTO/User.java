package com.example.demo.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
   
    @Column(name="first_name")
    private String firstName;
   
    @Column(name="last_name")
    private String lastName;
   
    @Column(name="mobile")
    private String mobile;
   
    @Column(name="email_id")
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;
    @ManyToOne
    @JoinColumn(name="user_type_id")
    private UserType userType;

}
