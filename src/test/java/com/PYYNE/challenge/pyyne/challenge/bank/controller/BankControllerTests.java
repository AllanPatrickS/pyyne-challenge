package com.PYYNE.challenge.pyyne.challenge.bank.controller;

import com.PYYNE.challenge.pyyne.challenge.bank.BankAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class BankControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BankAdapter adapter;
    @Mock
    private BankController controller;

    @Test
    void balancesShouldReturnTheBalancesList() throws Exception {
        mockMvc.perform(get("/bank/balances")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[215.5,512.5]")));
    }

    @Test
    void balanceShouldReturnTheBalance() throws Exception {
        mockMvc.perform(get("/bank/balance")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("728.0")));
    }

    @Test
    void transactionsShouldReturnTheTransactionList() throws Exception {
        mockMvc.perform(get("/bank/transactions")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "[{\"amount\":100.0,\"type\":\"Credit\",\"text\":\"Check deposit\"},{\"amount\":25.5," +
                                "\"type\":\"Debit\",\"text\":\"Debit card purchase\"},{\"amount\":225.0,\"type\":" +
                                "\"Debit\",\"text\":\"Rent payment\"},{\"amount\":125.0,\"type\":\"DEBIT\",\"text\":" +
                                "\"Amazon.com\"},{\"amount\":500.0,\"type\":\"DEBIT\",\"text\":\"Car insurance\"}," +
                                "{\"amount\":800.0,\"type\":\"CREDIT\",\"text\":\"Salary\"}]")));
    }
}
