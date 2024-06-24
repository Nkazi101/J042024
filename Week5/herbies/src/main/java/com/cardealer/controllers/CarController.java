package com.cardealer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardealer.models.Car;
import com.cardealer.services.CarService;

@Controller
public class CarController {
    
    @Autowired
    private CarService carService;


    @GetMapping("/cars")
    public String availableCars(Model model){

        List<Car> availCars = carService.findAvailableCars();

        model.addAttribute("availCars", availCars);

        return "availablecars";

    }

    //@PathVariable allows spirng to extract data from the url path
    //an id value will come from the anchor tag on the availablecars webpage
    //using PathVariable that id is bound to the id input
    @GetMapping("/cardetail/{id}")
    public String carDetail(@PathVariable Long id, Model model){

        //ask the carService to find the car in the database based on the id from the url
        Car car = carService.findCarById(id);

        //take the car object that was found, and send it to the webpage
        model.addAttribute("car", car);

        //load webpage with car
        return "cardetails";

    }


}
