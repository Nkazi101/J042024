package com.cardealer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cardealer.enums.UserRole;
import com.cardealer.models.User;
import com.cardealer.repositories.UserRepository;

//integrates the Junit 5 test framework with Mockito
//it initializes mocks annotated with "@Mock" and injects them into the class annotated with "@InjectMocks"
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    //create an instance of the class we're testing and inject the mocks
    //inject mocks creates an instance of "UserService" and injects the "userRepository, passwordEncoder, and authenticationManager into it"
    @InjectMocks
    private UserService userService;

    //This annotation is used to create mock instances of the fields
    //our mock objects are used to simulate the behavior of the actual dependencies
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    User user = new User();

    //initialize the mock objects. this line is necessary for processing the annotations and creating the mock objects
    //@BeforeEach is used to specify a method that should run before each test in the class
    @BeforeEach
    void setUp(){


        user.setEmail("timeflies@gmail.com");
        user.setPassword("password");
        user.setRole(UserRole.BUYER);

        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testSignUp(){


        //method stubbing: we want to be able to verify that the signup method correctly uses the encoded password WITHOUT worrying about the actual implementation of the of the passwordEncoder 
        //stubs provide predictable behavior during unit tests to make it more reliable
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        when(userRepository.save(any(User.class))).thenReturn(user);

        //verify the behavior through our assertion
        User savedUser = userService.signUp(user);

        assertNotNull(savedUser);
        assertEquals("timeflies@gmail.com", savedUser.getEmail());
        assertEquals("encodedPassword", savedUser.getPassword());
        assertEquals(UserRole.BUYER, savedUser.getRole());

        //to ensure a method is being called the correct number of times
        verify(userRepository, times(1)).save(any(User.class));


    }







    



}
