package com.real.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EnableJpaRepositories(basePackages = "com.real.repositories")

@EntityScan(basePackages = "com.real.models")

public class ApplicationConfig {
    



}
