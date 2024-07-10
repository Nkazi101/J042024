package com.cardealer.enums;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//enum: allows you to define a collection of related constants. Each constant is a distinct value.

@RequiredArgsConstructor
public enum UserRole {
    
        BUYER(Collections.emptySet()),
        SELLER(Set.of(

        Permission.SELLER_READ,
        Permission.SELLER_UPDATE,
        Permission.SELLER_CREATE,
        Permission.SELLER_DELETE

        ));


        @Getter
        private final Set<Permission> permissions;


        //the getAuthorites method converts the permissions into a list of "SimpleGrantedAuthority" objects, adding an authority for the role itself
        public List<SimpleGrantedAuthority> getAuthorities(){

                //get the list of permissions and covert it into a stream
                var authorities = getPermissions()
                .stream()
                //for each permission in the stream, a new "SimpleGrantedAuthority" is created using the permission's name
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                //the mapped authorities are collected into a list
                .collect(Collectors.toList());

                authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));


                return authorities;
        }

}
