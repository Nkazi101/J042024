package com.cardealer.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.enums.UserRole;
import com.cardealer.models.Car;
import com.cardealer.models.User;
import com.cardealer.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
    

    @Autowired
    private UserRepository userRepository;


    //going in the method is user information from the sign up page in the form of a user object\
    //going out of the method(after the user information is processed) is a saved User object
    public User signUp(User user){


        user.setRole(UserRole.BUYER);

        User savedUser =  userRepository.save(user);

        return savedUser;
    }


    public User signIn(String email, String password) throws Exception {

        //data we're working with: 
        //email , password

        //check if the user exists in the database based on the email given
        User foundUser = userRepository.findByEmail(email);

        //if a user is returned from the database
        if(foundUser != null){

            //check if the found user's password matches the user's password entered in the sign-in page
            if(foundUser.getPassword().equals(password)){

                //output the authenticated user
                return foundUser;
            }
            else{
                //wrong password was entered. throw the following exception
                throw new Exception("Invalid credentials. Try password again. ");
            }
           
        }
        throw new Exception("No account exists with the given email");

    }

   public User findUserById(Long id){

    Optional<User> user = userRepository.findById(id);


    return user.get();

   }
   

   public User editProfile(User user, HttpSession session){
    
    User sessionUser = (User) session.getAttribute("user");

    //retrieve the object you want to modify
    //go to the database and find the user that needs to be edited
    User usertoedit = userRepository.findById(sessionUser.getId()).orElse(null);

    //modify the object with information from the edit profile page
    usertoedit.setFirstName(user.getFirstName());
    usertoedit.setLastName(user.getLastName());
    usertoedit.setDateOfBirth(user.getDateOfBirth());
    usertoedit.setAddress(user.getAddress());
    usertoedit.setEmail(user.getEmail());
    usertoedit.setPhoneNumber(user.getPhoneNumber());

    //store the modified object in the user table
    //when you modify and object before calling the save method in the repository, it will run an update sql query instead of an insert query
    User editedUser = userRepository.save(usertoedit);

    return editedUser;

   }
 

}
