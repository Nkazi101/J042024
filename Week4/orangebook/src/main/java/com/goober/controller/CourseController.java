package com.goober.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goober.model.Course;
import com.goober.services.CourseService;

//the controller handles requests from the client/front-end/jsp's
//responsible for loading your webpage's
//it receives data from the jsp's and it sends data to the jsp's
@Controller
public class CourseController {
    

    @Autowired
    private CourseService courseService;

     //http methods/operations/mappings
    //GET - retrieve or load a resource, e.g. just loading a webpage
    //POST - submitting data, e.g. signing up, creating a new resource
    //PUT - update a record or entity, e.g updating user profile
    //DELETE - if you're trying to delete a particular resource

    @GetMapping("/courses")
    public String courses(Model model){
        
        List<Course> courses = courseService.findAllCourses();

        model.addAttribute("courses", courses);

        return "courses";

    }


}
