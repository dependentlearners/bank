package com.dependentlearners.common.representation;

import java.math.BigDecimal;

public class Transaction {
    private Customer sender;
    private Customer receiver;
    private BigDecimal amount;
    private String transactionText;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public void setTransactionText(String transactionText) {
        this.transactionText = transactionText;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public Customer getSender() {
        return sender;
    }

    public String getTransactionText() {
        return transactionText;
    }
}
