package com.alexiskyline.fraud.service;

import com.alexiskyline.fraud.models.FraudCheckHistory;
import com.alexiskyline.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer( Integer customerId ) {
        this.fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId( customerId )
                        .isFraudster( false )
                        .createdAt( LocalDateTime.now() )
                        .build()
        );
        return false;
    }
}