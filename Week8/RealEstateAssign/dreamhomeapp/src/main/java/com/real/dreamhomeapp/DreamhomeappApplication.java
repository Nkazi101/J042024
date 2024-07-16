package com.real.dreamhomeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.real")
public class DreamhomeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamhomeappApplication.class, args);
	}

}
