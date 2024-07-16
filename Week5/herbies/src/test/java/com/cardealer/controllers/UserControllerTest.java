package com.cardealer.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cardealer.config.ApplicationConfig;
import com.cardealer.herbies.HerbiesApplication;
import com.cardealer.services.UserService;

//this annotation tests the web layer
//it loads only the web layer beans and not the entire application context
// @RunWith(SpringRunner.class)
// @ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = HerbiesApplication.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    // @Autowired
    // private WebApplicationContext webApplicationContext;
    //MockMVC has methods that allow us to simulate http requests
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    // @BeforeEach
    // void setUp(){

    //     // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    //     MockitoAnnotations.openMocks(this);
    // }

    @Test
    void testLoadHome() throws Exception{

        //mockmvc.perfomr simulate your http request
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
        //andExpect verifies the result of the request, such as status code, view name and even model attributes
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("home"));
        

    }

}
