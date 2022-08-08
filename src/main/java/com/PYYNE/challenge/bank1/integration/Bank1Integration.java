package com.PYYNE.challenge.bank1.integration;

import com.PYYNE.challenge.pyyne.challenge.bank.BankGateway;
import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Integration with the Bank1.
 * Created by Allan on 08/07/22.
 */
@NoArgsConstructor
@Service
public class Bank1Integration implements BankGateway {
    private final Bank1AccountSource bankSource = new Bank1AccountSource();

    @Override
    public Double getBalance(Long accountId) {
        return bankSource.getAccountBalance(accountId);
    }

    @Override
    public List<Transaction> getTransactions(Long accountId, Date fromDate, Date toDate) {
        List<Bank1Transaction> transactions = bankSource.getTransactions(accountId, fromDate, toDate);
        return transactions.stream().map(tnx -> new Transaction(
                tnx.getAmount(), convertType(tnx.getType()), tnx.getText())).collect(Collectors.toList());
    }

    public String convertType(Integer type) {
        return type == 1 ? "Credit" : "Debit";
    }
}

