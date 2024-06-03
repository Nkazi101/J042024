package com.goober.orangebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.goober") 
public class OrangebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangebookApplication.class, args);
	}

}
