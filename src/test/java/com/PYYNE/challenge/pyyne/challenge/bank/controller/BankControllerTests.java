package com.PYYNE.challenge.pyyne.challenge.bank.controller;

import com.PYYNE.challenge.pyyne.challenge.bank.BankAdapter;
import com.PYYNE.challenge.pyyne.challenge.bank.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankControllerTests {
    @Mock
    private MockMvc mockMvc;
    @Mock
    private BankAdapter adapter;
    @Mock
    private BankController controller;

    @Test
    void balancesShouldReturnTheBalancesList() throws Exception {
        List<Double> balances = adapter.getBalances();
        when(controller.printBalances()).thenReturn(balances);

        mockMvc.perform(get("/bank/balances")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(balances.toString())));
    }

    @Test
    void balanceShouldReturnTheBalance() throws Exception {
        String balance = Double.toString(adapter.getBalance(0L));
        when(controller.printBalance()).thenReturn(balance);

        mockMvc.perform(get("/bank/balance")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(balance)));
    }

    @Test
    void transactionsShouldReturnTheTransactionList() throws Exception {
        List<Transaction> transactions = adapter.getTransactions(0L, new Date(), new Date());
        when(controller.printTransactions()).thenReturn(transactions);

        mockMvc.perform(get("/bank/transactions")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(transactions.toString())));
    }
}
