package com.PYYNE.challenge.bank2.integration;

import com.PYYNE.challenge.pyyne.challenge.bank.BankGateway;
import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Integration with the Bank2.
 * Created by Allan on 08/07/22.
 */
@NoArgsConstructor
@Service
public class Bank2Integration implements BankGateway {
    private final Bank2AccountSource bankSource = new Bank2AccountSource();

    @Override
    public Double getBalance(Long accountId) {
        return bankSource.getBalance(accountId).getBalance();
    }

    @Override
    public List<Transaction> getTransactions(Long accountId, Date fromDate, Date toDate) {
        List<Bank2AccountTransaction> transactions = bankSource.getTransactions(accountId, fromDate, toDate);
        return transactions.stream()
                .map(tnx -> new Transaction(tnx.getAmount(), tnx.getType().toString(), tnx.getText()))
                .collect(Collectors.toList());
    }
}
