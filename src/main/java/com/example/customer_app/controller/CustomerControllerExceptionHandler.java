package com.example.customer_app.controller;

import com.example.customer_app.exception.NoCustomerWithGivenIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerExceptionHandler {

    @ExceptionHandler(NoCustomerWithGivenIdException.class)
    public ResponseEntity<String> handleNoCustomerException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with given ID does not exist, please add the customer details");
    }
}
