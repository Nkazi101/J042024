package com.cardealer.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cart")
@Data
public class Cart {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many to many: multiple instances of one class are related to multiple instance of another class
    //a car can be in multiple carts, and cart can have multiple cars
    //a many to many joins two tables into one by taking the primary keys from each each table and using them as foreign keys to make a new table

    @ManyToMany
    @JoinTable(
         //the name of the table that will be formed from joining the two
    name = "carsincart",
    //specify the primary key of the first table you'd like to join, specifically the class you're currently in
    joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
    //the primary key of the other table, i.e. the collection you've declared to represent the many
    inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id")
    )
    private List<Car> itemsInCart = new ArrayList<>();


}


//unidirectional relationship means that only one entity knows about the relationship. i.e. you can only navigate one side of the relationship

//bidirectional means that both entities know about the relationship, i.e you can navigate the relationship on both sides