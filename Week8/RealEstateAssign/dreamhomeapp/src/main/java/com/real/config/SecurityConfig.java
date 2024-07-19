// package com.real.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {





//     public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {


//         http
//         .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        
//         .requestMatchers("/signin", "/signup", "/properties").permitAll()
        
//         .anyRequest().authenticated()
        
//         )
        
//         .formLogin(form -> form
//         .loginPage("http://:localhost:3000/signin")
//         .loginProcessingUrl("/signin")
        
        
//         );



//         return http.build();

        
//     }
    
// }
