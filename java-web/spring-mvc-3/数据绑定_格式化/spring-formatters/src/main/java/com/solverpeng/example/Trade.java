package com.solverpeng.example;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
public class Trade {
    private long tradeId;
    private String buySell;
    private Currency buyCurrency;
    private Currency sellCurrency;
    private BigDecimal amount;
    private LocalDate tradeDate;
}
