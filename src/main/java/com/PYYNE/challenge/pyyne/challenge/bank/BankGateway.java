/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PYYNE.challenge.pyyne.challenge.bank;

import java.util.Date;
import java.util.List;

/**
 * Bank gateway interface.
 * Created by Allan on 08/07/22.
 */
public interface BankGateway {
    public Double getBalance(Long accountId);
    public List<Transaction> getTransactions(Long accountId, Date fromDate, Date toDate);
}
