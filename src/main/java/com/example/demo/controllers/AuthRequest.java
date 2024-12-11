package com.example.demo.controllers;

import lombok.Setter;

@Setter
public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest(String username , String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

}
