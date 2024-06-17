// package com.goober.config;
 
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.goober.security.StudentDetailsServiceImpl;

// @Configuration
// public class WebSecurityConfig {
 
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new StudentDetailsServiceImpl();
//     }
     
//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
     
//     @Bean
//     public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(userDetailsService());
//         authProvider.setPasswordEncoder(passwordEncoder());
         
//         return authProvider;
//     }
 
//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.authorizeHttpRequests(
//                 auth -> auth
//                 .requestMatchers("/login", "/signup", "/courses", "/css/**", "/WEB-INF/jsp/**").permitAll()
//                 .anyRequest().authenticated())
//             .formLogin(login -> login.loginPage("/login").permitAll())
//             .logout(logout -> logout.permitAll())
//         ;
         
//         return http.build();
//     }
     
// }