package com.cardealer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

import static com.cardealer.enums.UserRole.SELLER;

import java.util.List;

import com.cardealer.enums.Permission;
import com.cardealer.enums.UserRole;
import com.cardealer.services.UserService;

//indicates that this class contains spring bean definitions
@Configuration
//enables web security support and provides the spring mvc integration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfig {
    
   
    private UserService userService;

    //Lazy is used to control the lazy initialization of beans
    //it means that a bean is created only when it is requested, rather than eagerly on application startup
    public SecurityConfig(@Lazy UserService userService){

        this.userService = userService;
    }

    

    //A bean is an object that is instantiated, assembled, and managed by a Spring IoC container.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {



        http
        //starts the configuration for authorizing http requests
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        //specify the url patterns and their access rules
        //.permitAll() allows anyone to access the endpoints
        .requestMatchers("/", "/signin", "/signinsubmit", "/cars", "/cardetail/{id}", "/signup", "/cart", "/WEB-INF/jsp/*", "/add/{id}", "/remove/{id}", "/userprofile", "/logout", "editprofile/{id}","/editprofile", "/css/**").permitAll()
        //.requestMatchers is used to configure url patterns and their access rules
        
        //hasRole() checks the granted authorities of the authenticated object
        .requestMatchers("/transactions").hasRole(SELLER.name())
        .requestMatchers(HttpMethod.GET, "/transactions").hasAuthority(Permission.SELLER_READ.name())
        // .requestMatchers("/v1/checkout/sessions").hasAnyAuthority("ROLE_BUYER")
        //any other request MUST be authenticated
        .anyRequest().authenticated()
    
        
        )
        //configure form based authentication
        .formLogin(form -> form
        //specify the custom login page url
        .loginPage("/signin")
        //the url to submit the email and password(form action)
        .loginProcessingUrl("/signin")
        //the default url to redirect after a successful login
        .defaultSuccessUrl("/")
        //allows all users to access the login page and submit login credentials
        .permitAll()
        
    )

    //configure the logout functionality
    .logout(logout -> logout
    //URL to trigger logout
    .logoutUrl("/logout")
    //invalidate/clear the session upon logout
    .invalidateHttpSession(true)
    //delete the session cookie
    .deleteCookies("JSESSIONID")
    .permitAll())
    
    
    .sessionManagement(session -> session

    //Create a new session and copy all existing session attributes to the new session.
    .sessionFixation().migrateSession()
    //define our session creation policy
    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
    //how many sessions a user can 
    .maximumSessions(3)
    //if the maximum sessions are reached what do we want to do
    //true: prevent new session, false: allow new session and expire the old one
    .maxSessionsPreventsLogin(false)

    
    ) ;

        return http.build();


    }

    //Password Encoder Bean
    //hashes the password securely
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Authentication Manager Bean
    //retrieve the authentication manager from the authentication configuration. The authentication is responsible for processing authentication requests
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
        
    }



    //should be automatically triggered by spring security when an authentication request is made
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;

    }

    @Bean
    public ProviderManager authManager(List<AuthenticationProvider> provider){

        return new ProviderManager(provider);
    }

    //
//    @Autowired
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception{

//        auth.authenticationProvider(authenticationProvider());

//     }

    //UserDetailsService bean
    //register our own "UserService class" as the UserDetailsService bean, which is used to load user details from the database. It does that via a method called "loadUserByUsername"
    @Bean
    public UserDetailsService userDetailsService(){
        return userService;
    }


    @Bean
    public ServletWebServerFactory servletContainer(){

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

        tomcat.addContextCustomizers(context -> context.setSessionTimeout(30));

        return tomcat;

    }



}
