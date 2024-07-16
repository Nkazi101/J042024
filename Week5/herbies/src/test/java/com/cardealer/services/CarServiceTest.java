package com.cardealer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cardealer.enums.BodyStyle;
import com.cardealer.models.Car;
import com.cardealer.repositories.CarRepository;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {


    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;


    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);

    }


    @Test
    void testfindAvailableCars(){

        //1. intialization of parameters
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue", "Automatic", 15000, "More reliable than the others!", "V6", BodyStyle.SEDAN, LocalDate.of(2023, 5, 15), 25000, true, false, "VN443093040403");
    
        Car car2 = new Car("Honda", "Civic", 2019, "Red", "Automatic", 15000, "More reliable than the others!", "V6", BodyStyle.COVERTIBLE, LocalDate.of(2024, 5, 17), 25000, true, false, "VN7868785878");

        Car car3 = new Car("Lexus", "IS250", 2021, "Black", "Automatic", 15000, "More reliable than the others!", "V6", BodyStyle.SUV, LocalDate.of(2022, 7, 20), 25000, true, false, "VN60596006795");
        

        List<Car> mockCarList = new ArrayList<>();

        mockCarList.add(car1);
        mockCarList.add(car2);
        mockCarList.add(car3);

        //2. creating mock objects and stubbing methods if required
        when(carRepository.findAll()).thenReturn(mockCarList);

        //3. Call the method you are testing with the parameters we initialized in step1;
        List<Car> availableCars = carService.findAvailableCars();

        //4. Add assertions to check the outcome of the test(pass or fail)
        assertNotNull(availableCars);
        assertEquals(3, availableCars.size());
        assertTrue(availableCars.contains(car1));
        assertTrue(availableCars.contains(car2));
        assertTrue(availableCars.contains(car3));

        verify(carRepository, times(1)).findAll();

    }


    
}
