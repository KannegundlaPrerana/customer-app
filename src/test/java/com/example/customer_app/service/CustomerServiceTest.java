package com.example.customer_app.service;

import com.example.customer_app.dto.CustomerDto;
import com.example.customer_app.entities.Customer;
import com.example.customer_app.exception.NoCustomerWithGivenIdException;
import com.example.customer_app.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    void shouldGetCustomerWithGivenId() {
        Customer customer = Customer.builder()
                .id(1)
                .firstName("Abcd")
                .lastName("Defg")
                .dateOfBirth(LocalDate.parse("2024-12-20"))
                .build();
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer actualCustomer = customerService.getCustomer(1);

        assertEquals(1, actualCustomer.getId());
    }

    @Test
    void shouldThrowExceptionIfGetCustomerIsCalledWithCustomerIdWhichDoesNotExist() {
        when(customerRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NoCustomerWithGivenIdException.class, () -> customerService.getCustomer(1));
    }

    @Test
    void shouldSaveCustomerAndReturnSavedCustomerId() {
        LocalDate date = LocalDate.now();
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(date)
                .build();

        Customer.CustomerBuilder customerBuilder = Customer.builder()
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(date);

        Customer customer = customerBuilder.build();
        Customer customerWithId = customerBuilder.id(1).build();

        when(customerRepository.save(customer)).thenReturn(customerWithId);

        int customerId = customerService.addCustomer(customerDto);

        assertEquals(1, customerId);
    }
}