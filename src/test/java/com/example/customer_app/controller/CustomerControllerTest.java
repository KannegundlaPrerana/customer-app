package com.example.customer_app.controller;

import com.example.customer_app.dto.CustomerDto;
import com.example.customer_app.entities.Customer;
import com.example.customer_app.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    void shouldGetCustomer() {
        Customer customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(LocalDate.now())
                .build();
        when(customerService.getCustomer(1)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getCustomer(1);

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        Customer responseBody = response.getBody();
        assertEquals(1, responseBody.getId());
        assertEquals("firstName", responseBody.getFirstName());
    }

    @Test
    void shouldAddCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(LocalDate.now())
                .build();
        when(customerService.addCustomer(customerDto)).thenReturn(1);

        ResponseEntity<Integer> response = customerController.addCustomer(customerDto);
        Integer responseBody = response.getBody();
        assertEquals(1, responseBody);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }
}