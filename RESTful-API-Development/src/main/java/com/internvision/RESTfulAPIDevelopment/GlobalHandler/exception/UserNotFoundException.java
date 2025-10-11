package com.internvision.RESTfulAPIDevelopment.GlobalHandler.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
