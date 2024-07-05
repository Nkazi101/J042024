package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.models.Transaction;
import com.cardealer.models.User;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.TransactionRepository;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CarRepository carRepository;

    //converting a cart to a transaction entity and we're saving that transaction using the transaction repository
    public boolean createTransaction(Cart cart, HttpSession session){

        //retrieve a user obect that was set in the session at sign-in
        User sessionUser = (User) session.getAttribute("user"); 


        //we create a new transaction object based on Transaction class in models folder
        Transaction transaction = new Transaction();
        //we set it's values
        transaction.setDate(LocalDate.now());
       
        transaction.setUser(sessionUser);
        transaction.setTotalAmount(calculateTotal(cart));

        //save the transaction to the db to generate the transaction id
        transactionRepository.save(transaction);

        //create a list to hold the updated car references
        List<Car> updatedCars = new ArrayList<>();

         //for each car in the cart we set the availabilty to false, and update it in the database
         for(Car car: cart.getItemsInCart()){

            car.setAvailable(false);
            car.setTransaction(transaction);
            carRepository.save(car);
            updatedCars.add(car);

        }

        //save the transaction to the db
        transaction.setItems(updatedCars);
        transactionRepository.save(transaction);

        return true;
    }

    public double calculateTotal(Cart cart){

        double total = 0;
        for(Car car: cart.getItemsInCart()){

            total = total + car.getPrice();
        }

        return total;
    }


    public List<Transaction> getAllTransactions(){


        List<Transaction> allTransactions = transactionRepository.findAllOrderByDateAsc();
 

        return allTransactions;

    }

    
}
