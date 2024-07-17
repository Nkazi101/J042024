package com.real.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.models.User;
import com.real.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User signup(User user) {

        return userRepository.save(user);
    }


    public User signIn(User user)throws Exception{

        User foundUser = userRepository.findByEmail(user.getEmail());

        if(foundUser == null){

            throw new Exception("User not found");

        }

        if(!foundUser.getPassword().equals(user.getPassword())){
            throw new Exception("Invalid credentials");
        }

        return foundUser;

    }

    public User findById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        return user;

    }
    
}
