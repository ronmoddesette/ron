package com.charter.ron.service;

import com.charter.ron.model.Purchase;
import com.charter.ron.model.Rewards;
import com.charter.ron.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Rewards getCustomerRewards(Long customerId){
        LocalDate endDate = null;
        LocalDate startDate = null; // includes current month
        Rewards rewards = new Rewards();
        rewards.setCustomerId(customerId);

        long points;
        for (int i=0; i<3; i++) {
            endDate = LocalDate.now().minusMonths(i);
            startDate = endDate.minusMonths(1);
            points = this.calculateMonthlyRewards(customerId,startDate,endDate);
            if (i == 0){
                rewards.setLastMonthPoints(points);
            }
            if(i == 1){
                rewards.setTwoMonthsAgoPoints(points);
            }
            if(i == 2){
                rewards.setThreeMonthsAgoPoints(points);
            }

        }
        return rewards;
    }

    private long calculateMonthlyRewards(Long customerId, LocalDate startDate, LocalDate endDate){
        long rewardPoints = 0L;
        List<Purchase> purchases = purchaseRepository.findAllByCustomerIdAndPurchaseDateGreaterThanAndPurchaseDateLessThanEqual(customerId,startDate,endDate);
        List<BigDecimal>purchaseAmounts = new ArrayList<>();
        purchases.forEach(p -> purchaseAmounts.add(p.getPurchaseAmount()));

        long totalPurchases = purchaseAmounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add).longValue(); //remove fractional dollar

        // rewards = 1 pt * spend above $50-$100 + 2pt * spend above $100
        // example:  $120 purchases results in (50 * 1) + (20 * 2) for 90 reward points
        long rewardsTwo = 0L;
        long rewardsOne = 0L;

        if(totalPurchases > 100L){
            rewardsTwo = (totalPurchases - 100L) * 2L;
            rewardPoints = 50 + rewardsTwo;

        }else if(totalPurchases > 50L) {
            rewardPoints = totalPurchases - 50L;
        }
        return rewardPoints;
    }
}
