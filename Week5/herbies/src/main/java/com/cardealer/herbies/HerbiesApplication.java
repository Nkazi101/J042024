package com.cardealer.herbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cardealer") 
public class HerbiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerbiesApplication.class, args);
	}

}
