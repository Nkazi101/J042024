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
    
}
