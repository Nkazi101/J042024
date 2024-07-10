package com.cardealer.enums;

import static com.cardealer.enums.UserRole.BUYER;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//generate a constructor for the "Permission" enum takes a string as an argument and it assigns it to the permission field
@RequiredArgsConstructor
public enum Permission {

    //constants representing various permissions associated with the SELLER role, each have a string value
    SELLER_READ("seller:read"),
    SELLER_UPDATE("seller:update"),
    SELLER_CREATE("seller:create"),
    SELLER_DELETE("seller:delete")


;   //automatically generate a getter method for the permission field
//so we can allow access to the string representation of each permission
    @Getter
    private final String permission;


}
