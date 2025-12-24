package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SaleTransaction {
    private Long id;
    private DiscountCode discountCode;
    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private Long customerId;

    public SaleTransaction() {}

    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public Timestamp getTransactionDate() { return transactionDate; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public Long getCustomerId() { return customerId; }

    public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
