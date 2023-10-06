package com.charter.ron.repository;

import com.charter.ron.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    List<Purchase> findAllByCustomerIdAndPurchaseDateGreaterThanAndPurchaseDateLessThanEqual(Long customerId, LocalDate startDate, LocalDate endDate);



}
