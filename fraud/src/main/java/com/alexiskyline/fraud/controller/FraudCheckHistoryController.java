package com.alexiskyline.fraud.controller;

import com.alexiskyline.fraud.models.FraudCheckHistoryResponse;
import com.alexiskyline.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/v1/fraud-check" )
@AllArgsConstructor
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping( path = "{customerId}" )
    public FraudCheckHistoryResponse isFraudster(@PathVariable Integer customerId ) {
        boolean isFraudulentCustomer = this.fraudCheckHistoryService.isFraudulentCustomer( customerId );
        return new FraudCheckHistoryResponse( isFraudulentCustomer );
    }
}