package com.alexiskyline.customer.service;

import com.alexiskyline.customer.model.Customer;
import com.alexiskyline.customer.model.CustomerRegistrationRequest;
import com.alexiskyline.customer.model.FraudCheckHistoryResponse;
import com.alexiskyline.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.fistName() )
                .lastName( request.lastName() )
                .email( request.email() )
                .build();

        // todo: check if email valid
        // todo: check if email not token
        // todo: store customer in db
        this.customerRepository.saveAndFlush( customer );

        // todo: check if fraud
        FraudCheckHistoryResponse fraudCheckHistoryResponse = this.restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class,
                customer.getId()
        );

        if( fraudCheckHistoryResponse.isFraudster() ) {
            throw new IllegalStateException( "Fraudster" );
        }
        // todo: send notification
    }
}