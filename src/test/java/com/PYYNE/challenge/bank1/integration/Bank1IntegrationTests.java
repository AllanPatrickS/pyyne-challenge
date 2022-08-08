package com.PYYNE.challenge.bank1.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class Bank1IntegrationTests {

    private Bank1AccountSource bankSource = new Bank1AccountSource();

    private Bank1Integration bank1Integration = new Bank1Integration();

    @Test
    void getBalanceShouldReturnAccountBalance() {
        assertThat(bank1Integration.getBalance(0L)).isEqualTo(bankSource.getAccountBalance(0L));
    }

    @Test
    void getTransactionsShouldReturnAccountTransactions() {
        assertThat(bank1Integration.getTransactions(0L, new Date(), new Date()).toString())
                .isEqualTo(bankSource.getTransactions(0L, new Date(), new Date()).stream()
                        .map(tnx -> new Transaction(tnx.getAmount(),
                                bank1Integration.convertType(tnx.getType()), tnx.getText()))
                        .collect(Collectors.toList()).toString());
    }
}
