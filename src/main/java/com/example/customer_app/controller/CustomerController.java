package com.example.customer_app.controller;

import com.example.customer_app.dto.CustomerDto;
import com.example.customer_app.entities.Customer;
import com.example.customer_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "/get-customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping(path = "/add-customer")
    public ResponseEntity<Integer> addCustomer(@RequestBody CustomerDto customerDto) {
        int id = customerService.addCustomer(customerDto);
        return ResponseEntity.ok().body(id);
    }
}
