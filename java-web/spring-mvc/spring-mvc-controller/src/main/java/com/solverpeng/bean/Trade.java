package com.solverpeng.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trade {
    private long tradeId;
    private BigDecimal amount;
    private LocalDate tradeDate;

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", amount=" + amount +
                ", tradeDate=" + tradeDate +
                '}';
    }
}
