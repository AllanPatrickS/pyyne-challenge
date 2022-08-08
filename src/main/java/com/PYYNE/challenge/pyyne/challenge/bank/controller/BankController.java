package com.PYYNE.challenge.pyyne.challenge.bank.controller;

import com.PYYNE.challenge.pyyne.challenge.bank.BankAdapter;
import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Controller that pulls information form multiple bank integrations and shows the result in the console and the
 * response.
 * Created by Allan on 08/07/22.
 */
@RestController
@RequestMapping("bank")
@AllArgsConstructor
public class BankController {
    private final BankAdapter adapter;

    @GetMapping("balances")
    public List<Double> printBalances() {
        List<Double> balances = adapter.getBalances();
        balances.forEach(balance -> {
            System.out.println(balance);
        });
        return balances;
    }

    @GetMapping("balance")
    public String printBalance() {
        String balance = Double.toString(adapter.getBalance(0L));
        System.out.println(balance);
        return balance;
    }

    @GetMapping("transactions")
    public List<Transaction> printTransactions() {
        List<Transaction> transactions = adapter.getTransactions(0L, new Date(), new Date());
        transactions.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
        return transactions;
    }
}
