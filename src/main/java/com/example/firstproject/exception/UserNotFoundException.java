package com.example.firstproject.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String name) {
        super(name);
    }

}
