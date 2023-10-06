package com.charter.ron.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rewards {

    // Represents 3 months of customer reward points plus 3 month total
    private long customerId;
    private long lastMonthPoints;
    private long twoMonthsAgoPoints;
    private Long threeMonthsAgoPoints;

    public long getTotalPoints() {
        return lastMonthPoints + twoMonthsAgoPoints + threeMonthsAgoPoints;
    }

}
