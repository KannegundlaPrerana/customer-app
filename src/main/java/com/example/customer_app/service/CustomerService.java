package com.example.customer_app.service;

import com.example.customer_app.dto.CustomerDto;
import com.example.customer_app.entities.Customer;
import com.example.customer_app.exception.NoCustomerWithGivenIdException;
import com.example.customer_app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public Customer getCustomer(int customerId) throws NoCustomerWithGivenIdException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            logger.debug("Retrieved customer with id:" + customer.getId());
            return customer;
        }

        throw new NoCustomerWithGivenIdException("Customer with given ID does not exist, ID:" + customerId);
    }

    public int addCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .dateOfBirth(customerDto.getDateOfBirth())
                .build();
        Customer addedCustomer = customerRepository.save(customer);
        logger.debug("Saved customer, id:" + addedCustomer.getId());

        return addedCustomer.getId();
    }
}
