package com.example.demo.domain.model;

import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Scope("prototype")
@ToString
public class Transaction {

    private String operation;
    private LocalDateTime date;
    private Double amount;
    private Double balance;

    public String getOperation() {
        return operation;
    }

    public Transaction setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Transaction setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Transaction setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public Transaction setBalance(Double balance) {
        this.balance = balance;
        return this;
    }
}

