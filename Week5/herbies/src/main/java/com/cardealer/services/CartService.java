package com.cardealer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.models.User;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.CartRepository;
import com.cardealer.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    //get cart

    public Cart getCart(HttpSession session){

        User sessionUser = (User) session.getAttribute("user");

        User user = userRepository.findById(sessionUser.getId()).orElse(null);

         //get cart previously set in the user session
        // Cart cart = (Cart) session.getAttribute("cart");

        Cart cart = user.getCart();

        //check if any cart was previously set in the user session
        if(cart == null){

            //initialize a new cart
            cart = new Cart();

            //set a new cart if no cart has been set
            session.setAttribute("cart", cart);

            //save cart in the db
            cartRepository.save(cart);

            //set the cart for the current signed in user
            user.setCart(cart);

            //update the user with that cart
            userRepository.save(user);

        }






return cart;
       
    }


    //save a cart
    //make the association of the user with cart
    //retrieve the user object, and set the cart for that user, store that user object with the cart in the db




    //add to cart
    public void addToCart(Long id, HttpSession session){

        //get the cart we want to add a car to
        Cart cart = getCart(session);

        //use the car id from the car details page to retrieve the car object from the db
        Car cartoAdd = carRepository.findById(id).orElse(null);

        //if we retrieve a car from the database
        if(cartoAdd != null){

             // that we want to add to our items in the cart List
             //get list of items in cart, and use the add method associated with the list collection to add the car to the list
             cart.getItemsInCart().add(cartoAdd);

             cartRepository.save(cart);

        }

       

    }
    //remove from cart
    public void removeFromCart(Long id, HttpSession session){

        //get the cart we want to remove a car from
        Cart cart = getCart(session);

        // List<Car> itemsToRemove = new ArrayList<>();

        Car carToRemove = null;
        
        for(Car car: cart.getItemsInCart()){

           if(car.getId() == id) {

           carToRemove = car;

            // itemsToRemove.add(car);

           }

        }
        cart.getItemsInCart().remove(carToRemove);

        cartRepository.save(cart);
        // cart.getItemsInCart().removeAll(itemsToRemove);

    }
}


//The ConcurrentModificationException is a runtime exception that is thrown in Java when an operation is performed on a collection (e.g. a list, set, or map) while another operation is being performed on the same collection