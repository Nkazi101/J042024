package com.cardealer.seeders;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.cardealer.enums.BodyStyle;
import com.cardealer.enums.UserRole;
import com.cardealer.models.Car;
import com.cardealer.models.User;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.UserRepository;

import lombok.val;

@Configuration
public class DataSeeder {
    

    //CommandLineRunner is used to execute code when the application starts
    @Bean
    // @DependsOn("flyway")
    CommandLineRunner initDatabase(CarRepository carRepository, UserRepository userRepository){

        return args -> {

            // for(Car car: carRepository.findAll()){

            //     if(!carRepository.existsByVIN(car.getVin())){

            // carRepository.save(new Car("Kia", "Forte", 2021, "Red", "Auto", 5000, "Life is a highway! Enjoy it with this Kia", "V8", BodyStyle.SEDAN, 9000, true, false, "VN040594050"));
            // carRepository.save(new Car("Toyota", "Camry", 2020, "Blue", "Auto", 12000, "Smooth ride, reliable performance!", "V6", BodyStyle.SEDAN, 15000, true, false, "JTNB11HK4L3098765"));
            // carRepository.save(new Car("Honda", "Civic", 2019, "Black", "Manual", 30000, "Efficient and sporty - the Civic way.", "I4", BodyStyle.SEDAN, 12000, false, true, "2HGFC2F79KH541231"));
            // carRepository.save(new Car("Ford", "Mustang", 2022, "Yellow", "Auto", 1500, "Feel the power of the Mustang!", "V8", BodyStyle.COUPE, 35000, true, true, "1FA6P8TH8N5156789"));
            // carRepository.save(new Car("Audi", "Q5", 2022, "Silver", "Auto", 5000, "Elegance and utility in an SUV.", "I4", BodyStyle.SUV, 45000, true, true, "WA1BNAFY5K2135678"));
            // carRepository.save(new Car("Mercedes-Benz", "C-Class", 2020, "Black", "Auto", 15000, "Experience the luxury of Mercedes-Benz.", "V6", BodyStyle.SEDAN, 38000, true, true, "WDDWF4JB3LR789012"));
            // carRepository.save(new Car("Tesla", "Model 3", 2023, "White", "Auto", 2000, "Drive the future with Tesla.", "Electric", BodyStyle.SEDAN, 50000, true, false, "5YJ3E1EA9JF200001"));
            // carRepository.save(new Car("Hyundai", "Tucson", 2019, "Red", "Auto", 22000, "Versatile SUV for all your adventures.", "I4", BodyStyle.SUV, 18000, true, false, "KM8J3CA46KU123456"));
            // carRepository.save(new Car("Subaru", "Outback", 2021, "Green", "Auto", 10000, "Reliable and rugged for the outdoors.", "H4", BodyStyle.SUV, 27000, true, true, "4S4BSANC7M3145678"));

            //     }
            // }



            // userRepository.save(new User("Nkazi", "Sibanda", LocalDate.of(1996, 07, 17) ,"6325 Victoria Ave", "sibanda.nkazimulo@gmail.com", "claim", "3146654673", UserRole.SELLER, true));
            // userRepository.save(new User("Michael", "Scott", LocalDate.of(1985, 03, 12) ,"1500 Sesame Street", "scottm@gmail.com", "hello", "5176030622", UserRole.SELLER, true));


        };
    }


}
