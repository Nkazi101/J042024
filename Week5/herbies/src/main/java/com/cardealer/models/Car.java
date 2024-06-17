package com.cardealer.models;

import java.time.LocalDate;
import java.util.List;

import com.cardealer.enums.BodyStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//model is the structure of the data that your application will manage
//marks a class as a persistent entity
//import annotations from Jakarta
@Entity
@Table(name = "car")
//@Data automatically generates boilerplate code e.g. getters/setters, no argument constructor, toString method, etc
@Data
public class Car {

    @Id
    //IDENTITY: relies on the database's auto-increment to generate primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacturername")
    private String manufacturerName;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "mileage")
    private double mileage;

    @Column(name = "dateofpurchase")
    private LocalDate dateOfPurchase;

    @Column(name = "photourl")
    private List<String> photoUrl;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "enginetype")
    private String engineType;

    @Column(name = "bodystyle")
    private BodyStyle bodyStyle;

    @Column(name = "price")
    private double price;

    @Column(name = "isavailable")
    private boolean isAvailable;

    @Column(name = "isnew")
    private boolean isNew;

    @Column(name = "vin", unique = true, nullable = false)
    private String vin;


    
}


//possible constraints : nullable, unique, primary key, length