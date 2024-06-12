package com.goober.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goober.model.Student;
import com.goober.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    

    public Student signUp(Student student){

        //we add the our means of password encryption

       Student savedStudent = studentRepository.save(student);

       return savedStudent;

    }

}
