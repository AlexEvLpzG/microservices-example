package com.alexiskyline.fraud.repository;

import com.alexiskyline.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {}