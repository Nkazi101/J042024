package com.goober.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentid;

    @Column(name = "departmentName", unique = true)
    private String deptName;

    //onetomany relationships are stored in a collection/list
    //one represents the class you're in, many represents the collection/list being declared
    @OneToMany
    @JoinColumn(name = "department_id", referencedColumnName = "departmentid")
    private List<Teacher> teachers;
    
}


//unidirectional relationship means that only one entity knows about the relationship. i.e. you can only navigate one side of the relationship

//bidirectional means that both entities know about the relationship, i.e you can navigate the relationship on both sides