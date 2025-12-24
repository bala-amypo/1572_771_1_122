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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }   // ✅ REQUIRED

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }

    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }

    public Timestamp getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
