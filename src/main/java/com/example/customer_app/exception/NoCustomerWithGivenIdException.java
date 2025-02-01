package com.example.customer_app.exception;

public class NoCustomerWithGivenIdException extends RuntimeException {
    public NoCustomerWithGivenIdException(String message) {
        super(message);
    }
}
