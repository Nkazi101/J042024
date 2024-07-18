package com.real.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.real.models.Property;
import com.real.services.PropertyService;

@RestController
@CrossOrigin("http://localhost:3000")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    @RequestMapping(
        value="/findunsoldproperties",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method=RequestMethod.GET
    )
    public ResponseEntity<Object> findUnsoldProperties(){

        try {

            List<Property> properties = propertyService.findUnsoldProperties();
            return new ResponseEntity<Object>(properties, HttpStatus.OK);
        }
    catch(Exception e){
    System.out.println(e.getMessage());
    return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    catch(Error e){
    System.out.println(e.getMessage());
    return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

}      

        
    } 

    
}
