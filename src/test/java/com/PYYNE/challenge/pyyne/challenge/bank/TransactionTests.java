package com.PYYNE.challenge.pyyne.challenge.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionTests {
    @Test
    void toStringShouldShowCorrectMessage () {
        Transaction transaction = new Transaction(1.0, "type", "text");
        assertThat(transaction.toString()).isEqualTo("amount = 1.000000, type = type, text = text");
    }
}
