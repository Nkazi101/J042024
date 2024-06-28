package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.repositories.CarRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {


    @Autowired
    private CarRepository carRepository;

    //get cart

    public Cart getCart(HttpSession session){


         //get cart previously set in the user session
        Cart cart = (Cart) session.getAttribute("cart");

        //check if any cart was previously set in the user session
        if(cart == null){

            //initialize a new cart
            cart = new Cart();

            //set a new cart if no cart has been set
            session.setAttribute("cart", cart);

        }
       
return cart;
       
    }

    //add to cart
    public void addToCart(Long id, HttpSession session){

        //get the car we want to add a car to
        Cart cart = getCart(session);

        //use the car id from the car details page to retrieve the car object from the db
        Car cartoAdd = carRepository.findById(id).orElse(null);

        //if we retrieve a car from the database
        if(cartoAdd != null){

             // that we want to add to our items in the cart List
             //get list of items in cart, and use the add method associated with the list collection to add the car to the list
             cart.getItemsInCart().add(cartoAdd);

        }

       

    }


    //remove from cart
    
}
