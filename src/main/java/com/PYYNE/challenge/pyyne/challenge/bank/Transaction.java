package com.PYYNE.challenge.pyyne.challenge.bank;

import lombok.*;

/**
 * Transaction class.
 * Created by Allan on 08/07/22.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private Double amount;
    private String type;
    private String text;

    @Override
    public String toString () {
        return String.format("amount = %f, type = %s, text = %s", amount, type, text);
    }
}
