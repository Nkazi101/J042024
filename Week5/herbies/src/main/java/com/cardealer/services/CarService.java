package com.cardealer.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
       List<Car> discCars = discountedCars(availCars);

        return discCars;
    }

    public Car findCarById(Long id){

        Optional<Car> car = carRepository.findById(id);

        return car.get();

    }

    public Car addCar(Car car){

        LocalDate currentDate = LocalDate.now();

        car.setDateAdded(currentDate);

        Car savedCar = carRepository.save(car);

        return savedCar;

    }


    public List<Car> discountedCars(List<Car> cars){

        //iterate through all cars passed into the method, e.g. using a loop

        for(Car car: cars){

             //check how long the car has been inventory
            LocalDate startDate = car.getDateAdded();
            LocalDate endDate = LocalDate.now();

            long daysbetween = ChronoUnit.DAYS.between(startDate, endDate);

             //if the car has been in inventory more 120 days

             if(daysbetween > 120 && car.getDiscountApplied() == false){

                // apply discount

                double newPrice = car.getPrice() * .90;

                 //update the price of the car in the database after the discount is applied

                 car.setPrice(newPrice);

                   //ensure that we apply the discount only once 
                 car.setDiscountApplied(true);

                 carRepository.save(car);

             }

        }


       return cars;

    }

    public List<Car> findCarByModel(String model){

       List<Car> cars = carRepository.findCarByModel(model);

       return cars;


    }



    
}
