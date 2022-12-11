package com.alexiskyline.fraud.controller;

import com.alexiskyline.fraud.models.FraudCheckHistoryResponse;
import com.alexiskyline.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/v1/fraud-check" )
@AllArgsConstructor
@Slf4j
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping( path = "{customerId}" )
    public FraudCheckHistoryResponse isFraudster(@PathVariable Integer customerId ) {
        boolean isFraudulentCustomer = this.fraudCheckHistoryService.isFraudulentCustomer( customerId );
        log.info( "fraud check request from customer {}", customerId );
        return new FraudCheckHistoryResponse( isFraudulentCustomer );
    }
}