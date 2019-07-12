package com.solverpeng.example;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
public class Trade {
    private long tradeId;
    private String buySell;
    private Currency buyCurrency;
    private Currency sellCurrency;
    @NumberFormat(pattern = "#,###,###,###.##")
    private BigDecimal amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tradeDate;
}
