package com.PYYNE.challenge.pyyne.challenge.bank;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter of the Banks.
 * Created by Allan on 08/07/22.
 */
@AllArgsConstructor
@Service
public class BankAdapter {
    private final List<BankGateway> bankGateways;

    /*
     * Iterates through all the gateways and fetch the balance for the provided account summing all the results
     */
    public Double getBalance(Long accountId) {
        return bankGateways.stream().map(gateway -> gateway.getBalance(accountId)).reduce(0.0, Double::sum);
    }

    /*
     * Iterates through all the gateways and fetch the balances combined into a single list
     */
    public List<Double> getBalances() {
        return bankGateways.stream().map(gateway -> gateway.getBalance(0L)).collect(Collectors.toList());
    }

    /*
     * Iterates through all the gateways and fetch the transactions for the provided account combined into a single list
     */
    public List<Transaction> getTransactions(Long accountId, Date fromDate, Date toDate) {
        return bankGateways.stream().map(gateway -> gateway.getTransactions(accountId, fromDate, toDate))
                .flatMap(Collection::stream).collect(Collectors.toList());
    }
}
