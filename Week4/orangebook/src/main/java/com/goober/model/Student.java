package com.goober.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

//marks a class as a persistent entity
//peristence is storing and retrieving objects from the database
@Entity
//specify the primary table for the annotated entity
@Table(name = "student")
@Data
public class Student {

    //private instance variables
    //specifies the primary key for any entity
    @Id
    //Specifies how the primary key should be generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    //specifies the details of the column to which a field will be mapped
    //constraints are entered in the parantheses of the column annotation
    @Column(name = "firstname", length = 1000)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "gradelevel")
    private String gradeLevel;

    @Column(name = "gpa")
    private double gpa;

    @Column(name = "dateofbirth")
    private String dateofBirth;

    // @Column(name = "role")
    // private String role;

    // @Column(name = "enabled")
    // private boolean enabled;


    @ManyToMany
    //use a join table along with the many to many annotation
    @JoinTable(
        //the name of the table that will be formed from joining the two
    name = "student_courses",
    //specify the primary key of the first table you'd like to join, specifically the class you're currently in
    joinColumns = @JoinColumn(name = "student_id"),
    //the primary key of the other table, i.e. the collection you've declared to represent the many
    inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;




    
}
