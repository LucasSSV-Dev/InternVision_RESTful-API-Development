package com.internvision.RESTfulAPIDevelopment.common.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
