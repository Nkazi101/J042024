package com.goober.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import com.goober.model.Student;

//the controller manages/processes user requests coming from the client
//when a request is made on a webpage, the dispatcher servlet finds the appropriate method to process the request based on the httpmethod and endpoint name
@Controller
public class StudentController {

    //declare a list of students
    List<Student> students = new ArrayList<>();

    //http methods/operations/mappings
    //GET - retrieve or load a resource, e.g. just loading a webpage
    //POST - submitting data, e.g. signing up, creating a new resource
    //PUT - update a record or entity, e.g updating user profile
    //DELETE - if you're trying to delete a particular resource

    //endpoint is a specific url/uri where a resource can be found
    //it is accessed by an application
    //every endpoint is associated with a method
    @GetMapping("/signup")
    public String signUp(){


        return "signup";
    }


    //@ModelAttribute is going to bind the data from the form to the input object.
    //the Model class allows you to send data to your jsp's/views.
    //when do you use the Model class as an input? Whenever you want to send data to a view
    @PostMapping("/signup")
    public String submitsignUp(@ModelAttribute Student student, Model model){


        //i call my list of students and add the student to the list
        students.add(student);

        //this will add the students arrays to the students.jsp webpage
        model.addAttribute("students", students);

        return "students";

    }

    @GetMapping("/students")
    public String studentlist(Model model){

        model.addAttribute("students", students);

        return "students";

    }
   

   



    
}
