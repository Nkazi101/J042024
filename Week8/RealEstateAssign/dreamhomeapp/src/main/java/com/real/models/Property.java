package com.real.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "property")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "size")
    private double size;

    @Column(name = "price")
    private double price;

    @Column(name = "contactInfo")
    private String contactInformation;

    @Column(name = "sold")
    private Boolean sold = false;

    @Column(name = "dateSold")
    private LocalDate dateSold;



    
}
