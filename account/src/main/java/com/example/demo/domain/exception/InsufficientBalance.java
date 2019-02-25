package com.example.demo.domain.exception;

public class InsufficientBalance extends RuntimeException {

    public InsufficientBalance() {
        super("Insufficient Balance !!!");
    }
}
