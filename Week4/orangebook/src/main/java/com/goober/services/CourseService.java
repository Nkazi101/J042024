package com.goober.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goober.model.Course;
import com.goober.repository.CourseRepository;


//this is the business logic layer
//this will allow you to process(validation, authentication, manipulation, filtering, etc) data before it reaches the database or if it is coming from the database
//e.g. encryption of password before reaching the database, validation of user for sign-in
@Service
public class CourseService {

    //dependency injection
    //it allows us to use the resource inside of an object

    //Dependency: An object that another object relies on 
    //Injection: The process of passing the dependency to a dependent object
    //field injection: Dependencies are injected directly into the fields of a class
    @Autowired
    private CourseRepository courseRepository;


    public List<Course> findAllCourses(){

        //the find all method will retreive all the courses in the course table
        //we declared a variable called "courses" which will hold/store the results of the query
        List<Course> courses = courseRepository.findAll();

        return courses;

    }
 
    
}
