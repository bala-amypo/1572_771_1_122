package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "sale_transaction")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_code_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DiscountCode discountCode;

    @Column(nullable = false)
    private BigDecimal saleAmount;

    private LocalDateTime transactionDate;

    @PrePersist
    public void onCreate() {
        this.transactionDate = LocalDateTime.now();
    }

    public SaleTransaction() {}

    // Getters & Setters
    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getSaleAmount() { return saleAmount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }

    public void setId(Long id) { this.id = id; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setSaleAmount(BigDecimal saleAmount) { this.saleAmount = saleAmount; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
