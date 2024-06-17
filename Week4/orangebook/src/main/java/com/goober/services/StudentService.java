package com.goober.services;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.goober.model.Student;
import com.goober.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;
    

    public Student signUp(Student student){

        //we add the our means of password encryption

    //  student.setPassword(passwordEncoder.encode(student.getPassword()));
       Student savedStudent = studentRepository.save(student);

       return savedStudent;

    }


    public Student signIn(Student student) throws Exception {

        //check whether this student exists in the database
        //Repository needs to retreive a student from the database to check if they exists
        //getters and setters are coming from the Student class
        //foundStudent is a container that will hold whatever object is returned from the database

        Student foundStudent = studentRepository.findByEmail(student.getEmail());
        
       
        //check if any student object was returned from the database
        if(foundStudent == null){

            throw new Exception("No account associated with given email");
        }
        //check whether the password entered matches the password of the object we got back from the repository/database
        if(!foundStudent.getPassword().equals(student.getPassword())){

            throw new Exception("Invalid Credentials. Incorrect Password");

        }

        return foundStudent;
    }
}
