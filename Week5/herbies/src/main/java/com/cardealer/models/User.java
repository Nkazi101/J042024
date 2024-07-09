package com.cardealer.models;

import java.time.LocalDate;
import java.util.List;

import com.cardealer.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    //@Enumerated specifies how the enum should be persisted in the database
    //@EnumType.ORDINAL: store the enum as an integer based on index
    //@EnumType.STIRNG: store the enum as a string, corresponding to the name of enum constant
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Column(name = "rolie")
    private String rolie;

    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin= false;

    //onetomany relationships are stored in a collection/list
    //one represents the class you're in, many represents the collection/list being declared
    //one to many are typically combined with the join column annotation
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Car> cars;

    // public User(String firstName, String lastName, LocalDate dateOfBirth, String address, String email, String password,
    //         String phoneNumber, UserRole role, boolean isAdmin) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.dateOfBirth = dateOfBirth;
    //     this.address = address;
    //     this.email = email;
    //     this.password = password;
    //     this.phoneNumber = phoneNumber;
    //     this.role = role;
    //     this.isAdmin = isAdmin;
    // }

    public User(){


    }

    
    
}


//backlog:


//associate user with cart so user can access the same cart upon login on another device
//add a remove all button to cart page
//take in multiple photos on add car page

//spring security
//unit testing
