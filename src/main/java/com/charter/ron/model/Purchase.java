package com.charter.ron.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Purchase {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate purchaseDate;

    private BigDecimal purchaseAmount;

    private Long customerId;





}
