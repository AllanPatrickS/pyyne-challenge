package com.PYYNE.challenge.bank2.integration;

import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class Bank2IntegrationTests {

    private Bank2AccountSource bankSource = new Bank2AccountSource();


    private Bank2Integration bank2Integration = new Bank2Integration();

    @Test
    void getBalanceShouldReturnAccountBalance() {
        assertThat(bank2Integration.getBalance(0L)).isEqualTo(bankSource.getBalance(0L)
                .getBalance());
    }

    @Test
    void getTransactionsShouldReturnAccountTransactions() {
        assertThat(bank2Integration.getTransactions(0L, new Date(), new Date()).toString())
                .isEqualTo(bankSource.getTransactions(0L, new Date(), new Date()).stream()
                        .map(tnx -> new Transaction(tnx.getAmount(), tnx.getType().toString(), tnx.getText()))
                        .collect(Collectors.toList()).toString());
    }

}
