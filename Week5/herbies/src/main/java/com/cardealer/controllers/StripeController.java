package com.cardealer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.services.CartService;
import com.cardealer.services.TransactionService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpSession;

//you're marking this as a class where every method is returning a response object instead of a view
//it's combination of @Controller and @ResponseBody
@Controller
public class StripeController {


    //It can read values from application properties
    @Value("${stripe.apiKey}")
    public String stripeApiKey;

    @Autowired
    private CartService cartService;

    @Autowired
    private TransactionService transactionService;


    //ResponseEntity<Object> represents the entire http response, and it includes: status code, headers, body

    //status code: indicates the results of the http request, .e.g 200 OK, 201 CREATED, 400 BAD REQUEST, 404 NOT FOUND, 500 INTERNAL SERVER ERROR etc

    //headers: allow you to add metadata to the response, e.g. content type: JSON or xml, authorization

    //body: the actual data being returned in the response. This can be any type of object


    // @GetMapping("/v1/balance")
    
    // @RequestMapping(
    //     value="/v1/balance",
    //     produces = MediaType.APPLICATION_JSON_VALUE,
    //     method = RequestMethod.GET
    // )
    // public ResponseEntity<Object> balance(){

    //     Stripe.apiKey=stripeApiKey;

    //     try{

    //          Balance balance = Balance.retrieve();

    //          return new ResponseEntity<Object>(balance.toJson(), HttpStatus.OK);

    //     }
    //    catch(StripeException e){

    //     return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    //    }

    // }


    @GetMapping("/v1/checkout/sessions")
public String createCheckout(HttpSession session){

  Stripe.apiKey = stripeApiKey;
 
  Cart cart = cartService.getCart(session);

List<SessionCreateParams.LineItem> lineitems = new ArrayList<>();

  for(Car car: cart.getItemsInCart()){

    lineitems.add(   
    SessionCreateParams.LineItem.builder()
        .setPrice(car.getStripePriceid())
        .setQuantity(1L)
        .build()
    );
  }

SessionCreateParams params =
  SessionCreateParams.builder()
    .setSuccessUrl("http://localhost:8080/payment/success")
    .setCancelUrl("http://localhost:8080/payment/failed")
    .addAllLineItem(lineitems)
    .setMode(SessionCreateParams.Mode.PAYMENT)
    
    
    .build();


    try {

        Session sessionStripe = Session.create(params);

        // Long amount = sessionStripe.getAmountTotal();

        return "redirect:" + sessionStripe.getUrl();

      
        
    } catch (Exception e) {
       
        return "redirect:/checkout/error";
    }
        
    }


@GetMapping("/payment/success")
public String successPay(HttpSession session){

  Cart cart = cartService.getCart(session);

  transactionService.createTransaction(cart, session);


  return "success";


}



}