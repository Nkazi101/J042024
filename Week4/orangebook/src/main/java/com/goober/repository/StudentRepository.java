package com.goober.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.goober.model.Student;


//the repository inherits from the JpaRepository so it has all its methods.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    

    //custom query which will load a student object from the database based on email
    //native query: these queries are sql statements which can be directly executed in the database
    //?1 is a placeholder for the email coming in as input inside the custom method "findByEmail"
    @Query(value = "select * from student where email = ?1", nativeQuery = true)
    public Student findByEmail(String email);


}
