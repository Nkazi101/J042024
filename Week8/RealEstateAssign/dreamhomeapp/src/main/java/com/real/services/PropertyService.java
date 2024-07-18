package com.real.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.real.models.Property;
import com.real.repositories.PropertyRepository;

@Service
public class PropertyService {


    @Autowired
    private PropertyRepository propertyRepository;


    public List<Property> findUnsoldProperties(){

        List<Property> properties = propertyRepository.findBySoldFalse();

        return properties;

    }
    
}
