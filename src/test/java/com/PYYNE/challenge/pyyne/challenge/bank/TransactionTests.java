package com.PYYNE.challenge.pyyne.challenge.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionTests {
    @Mock
    private Double amount = 0.0;
    @Mock
    private String type = "test";
    @Mock
    private String text = "mock";

    @Test
    void toStringShouldShowCorrectMessage () {
        
    }
}
