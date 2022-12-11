package com.alexiskyline.customer.service;

import com.alexiskyline.customer.model.Customer;
import com.alexiskyline.customer.model.CustomerRegistrationRequest;
import com.alexiskyline.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.fistName() )
                .lastName( request.lastName() )
                .email( request.email() )
                .build();

        // todo: check if email valid
        // todo: check if email not token
        // todo: store customer in db
        this.customerRepository.save( customer );
    }
}