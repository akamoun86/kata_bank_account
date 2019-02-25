package com.example.demo.domain.service.impl;

import com.example.demo.domain.exception.InsufficientBalance;
import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    BeanFactory beanFactory;

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public String getHistory() {
        return transactions.toString();
    }

    @Override
    public double deposit(double amount) {
        Transaction depositTransaction = beanFactory.getBean(Transaction.class);
        depositTransaction.setOperation("Deposit")
                .setAmount(amount)
                .setDate(LocalDateTime.now())
                .setBalance(transactions.isEmpty() ? amount : transactions.get(transactions.size() - 1).getBalance() + amount);

        transactions.add(depositTransaction);
        return depositTransaction.getBalance();
    }

    @Override
    public double withdraw(double amount) {
        Transaction withdrawTransaction = beanFactory.getBean(Transaction.class);
        withdrawTransaction.setOperation("Withdraw")
                .setAmount(amount)
                .setDate(LocalDateTime.now())
                .setBalance(getBalanceWithdraw(amount));

        transactions.add(withdrawTransaction);
        return withdrawTransaction.getBalance();

    }

    private double getBalanceWithdraw(double amount) {
        Transaction last = transactions.isEmpty() ? null : transactions.get(transactions.size() - 1);
        if (last.getBalance() >= amount) {
            return last.getBalance() - amount;
        }
        throw new InsufficientBalance();
    }
}
