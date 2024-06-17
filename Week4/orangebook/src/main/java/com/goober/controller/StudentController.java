package com.goober.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import com.goober.model.Student;
import com.goober.services.StudentService;
import org.springframework.web.bind.annotation.RequestParam;


//the controller manages/processes user requests coming from the client
//when a request is made on a webpage, the dispatcher servlet finds the appropriate method to process the request based on the httpmethod and endpoint name
@Controller
public class StudentController {

    // //declare a list of students
    // List<Student> students = new ArrayList<>();

    @Autowired
    private StudentService studentService;

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
    
    @PostMapping("/signup")
    public String submitsignUp(@ModelAttribute Student student){

        Student savedStudent = studentService.signUp(student);

        // //i call my list of students and add the student to the list
        // students.add(student);

        return "redirect:/courses";

    }



    @GetMapping("/signin")
    public String signIn(){

        return "signin";

    }

    //the Model class allows you to send data to your jsp's/views.
    //when do you use the Model class as an input? Whenever you want to send data to a view
    @PostMapping("/signin")
    public String submitSignIn(@ModelAttribute Student student, Model model){

        //if the exception in the sign in method in the student service is thrown, we should be able to catch it. if any errors occur in the try block, the catch block will have an alternative batch of code that will run

        try {
       Student loggedInStudent =  studentService.signIn(student);
        
       //addAttribute allows you to pass an object to a webpage
       model.addAttribute("student", loggedInStudent);

       return "home";

        }
        catch(Exception e){

            System.out.println(e.getMessage());
            return "signin";
        }
    }









    // @GetMapping("/students")
    // public String studentlist(Model model){

    //     model.addAttribute("students", students);

    //     return "students";

    // }
   

   



    
}
