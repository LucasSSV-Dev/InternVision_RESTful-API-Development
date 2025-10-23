package com.internvision.RESTfulAPIDevelopment.globalhandler.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String message) {
        super(message);
    }
}
