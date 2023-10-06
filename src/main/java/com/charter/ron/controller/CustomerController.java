package com.charter.ron.controller;

import com.charter.ron.model.Rewards;
import com.charter.ron.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<Rewards> getCustomerRewards(@RequestParam(value = "id") Long id){
        try {
            Rewards rewards = customerService.getCustomerRewards(id);
            return new ResponseEntity<>(rewards, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Bad request ");
        }
    }

}
