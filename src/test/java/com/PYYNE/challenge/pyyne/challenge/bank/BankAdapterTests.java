package com.PYYNE.challenge.pyyne.challenge.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BankAdapterTests {

    @Test
    void getBalancesShouldReturnBalances() {
        assertThat(bank1Integration.getBalance(0L)).isEqualTo(bankSource.getAccountBalance(0L));
    }

    @Test
    void getBalanceShouldReturnBalance() {
        assertThat(bank1Integration.getBalance(0L)).isEqualTo(bankSource.getAccountBalance(0L));
    }

    @Test
    void getTransactionsShouldReturnTransactions() {
        assertThat(bank1Integration.getBalance(0L)).isEqualTo(bankSource.getAccountBalance(0L));
    }

}
