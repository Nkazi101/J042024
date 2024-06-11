package com.goober.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "teacher")
//automatically implements boilerplate code like getter/setter methods, empty constructors, and toString method, etc
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherid;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "office_id", referencedColumnName = "officeId")
    private Office office;
    
}

//one to one & one to many are typically combined with the join column annotation
//many to many is combined with the join table annotation