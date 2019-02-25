package com.example.demo.service.rest.impl;

import com.example.demo.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping("/history")
    public String getHistory(){
        return  accountService.getHistory();
    }

    @PutMapping(value = "/deposit/{amount}")
    public ResponseEntity deposit(@PathVariable("amount") double amount) {
        double balance = accountService.deposit(amount);
        return ResponseEntity.ok(balance);
    }

    @PutMapping(value = "/withdraw/{amount}")
    public ResponseEntity withdraw(@PathVariable("amount") double amount) {
        double balance = accountService.withdraw(amount);
        return ResponseEntity.ok(balance);
    }
}
