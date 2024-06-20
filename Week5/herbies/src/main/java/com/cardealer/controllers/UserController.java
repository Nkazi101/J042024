package com.cardealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cardealer.models.User;
import com.cardealer.services.UserService;

//the controller manages/processes user requests coming from the client
//when a request is made on a webpage, the dispatcher servlet finds the appropriate method to process the request based on the httpmethod and endpoint name

//@Controller indicates that the class is a web controller. 
//The controller processes user input, interacts with the service layer to handle business logic, and return views or data as responses.
@Controller
public class UserController {


    //the service layer depends on the controller
        //dependency injection
    //it allows us to use the resource inside of an object

    //Dependency: An object that another object relies on 
    //Injection: The process of passing the dependency to a dependent object
    //field injection: Dependencies are injected directly into the fields of a class
    //autowired allows for automatic dependency injections
    @Autowired
    private UserService userService;

      //http methods/operations/mappings
    //GET - retrieve or load a resource, e.g. just loading a webpage
    //POST - submitting data, send data to the server/database e.g. signing up, creating a new resource
    //PUT - update a record or entity, e.g updating user profile
    //DELETE - if you're trying to delete a particular resource


    @GetMapping("/")
    public String loadHome(){



        return "home";
    }


    @GetMapping("/signin")
    public String signIn(){

        return "signin";
    }


    @GetMapping("/signup")
    public String signUp(){

        return "signup";
    }

    //@ModelAttribute is going to bind the data from the form to the input object.
    //Data binding: the process of mapping data from HTTP requests(e.g. a form submission) to Java objects or models. Important for processing user input or displaying data
    //we need our information e.g. user object in object form so we can process it. 
    @PostMapping("/signup")
    public String submitSignUp(@ModelAttribute User user){

       User savedUser = userService.signUp(user);

       return "signin";

    }


    //the Model interface allows you to send data to your jsp's/views.
    //when do you use the Model interface as an input? Whenever you want to send data to a view

    @PostMapping("/signin")
    public String submitSignIn(@ModelAttribute User user, Model model){

        try{
       
         User authenticatedUser = userService.signIn(user);

         //the parameters of addAttribute include: "attrbuteName" used to access the object on the webpage, and then you have the actual object you want to pass to the webpage
         model.addAttribute("user", authenticatedUser);

         return "home";

        }
        catch(Exception e){

            model.addAttribute("errorMessage", e.getMessage());

            return "signin";

        }

    }







    
}
