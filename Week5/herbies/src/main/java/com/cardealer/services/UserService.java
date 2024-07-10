package com.cardealer.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cardealer.enums.UserRole;
import com.cardealer.models.Car;
import com.cardealer.models.User;
import com.cardealer.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService implements UserDetailsService {
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UserService(@Lazy AuthenticationManager authenticationManager){

        this.authenticationManager = authenticationManager;

    }


    //going in the method is user information from the sign up page in the form of a user object\
    //going out of the method(after the user information is processed) is a saved User object
    public User signUp(User user){


        user.setRole(UserRole.BUYER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser =  userRepository.save(user);

        return savedUser;
    }

    public User signIn(String email, String password) throws Exception {

        try {
        //the method authenticate is used to authenticate the user

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        //the getprincipal method returns the "UserDetails" implementation, and then convert(cast) it to a user object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        System.out.println(userDetails);

        return userRepository.findByEmail(userDetails.getUsername());

        }catch(AuthenticationException e){

            throw new Exception("Invalid credentials. Try password again. ");
            

        }



    }

    // public User signIn(String email, String password) throws Exception {

    //     //data we're working with: 
    //     //email , password

    //     //check if the user exists in the database based on the email given
    //     User foundUser = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

    //     //if a user is returned from the database
    //     if(foundUser != null){

    //         //check if the found user's password matches the user's password entered in the sign-in page
    //         if(passwordEncoder.matches(password, foundUser.getPassword())){

    //             //output the authenticated user
    //             return foundUser;
    //         }
    //         else{
    //             //wrong password was entered. throw the following exception
    //             throw new Exception("Invalid credentials. Try password again. ");
    //         }
           
    //     }
    //     throw new Exception("No account exists with the given email");

    // }

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
 
   //create an implemenation of loadUserByUserName
   @Override
   public UserDetails loadUserByUsername(String email) {

    User user = userRepository.findByEmail(email);

    if(user == null){
        throw new UsernameNotFoundException("User not found");
    }

    System.out.println(user.getRole().name());
    //create a return a UserDetails object based on the retrieve user
    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getAuthorities());
    //set the list of authorities(roles) granted to the user);

   }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//        return user;
//    }

}
