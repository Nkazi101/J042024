package com.cardealer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Car;
import com.cardealer.repositories.CarRepository;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;


    public List<Car> findAvailableCars(){

        List<Car> allCars = carRepository.findAll();

        List<Car> availCars = new ArrayList<>();

        for(Car car: allCars){

            if(car.isAvailable()){

                availCars.add(car);
            }
        }
        return availCars;
    }

    public Car findCarById(Long id){

        Optional<Car> car = carRepository.findById(id);

        return car.get();

    }
    
    
}
