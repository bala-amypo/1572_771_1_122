package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    private BigDecimal totalSales;
    private Integer totalTransactions;
    private Double roiPercentage;

    @Column(nullable = false, updatable = false)
    private Timestamp generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    public RoiReport() {}

    public RoiReport(DiscountCode discountCode,
                     BigDecimal totalSales,
                     Integer totalTransactions,
                     Double roiPercentage) {
        this.discountCode = discountCode;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
    }

    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTotalSales() { return totalSales; }
    public Integer getTotalTransactions() { return totalTransactions; }
    public Double getRoiPercentage() { return roiPercentage; }
    public Timestamp getGeneratedAt() { return generatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(Integer totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(Double roiPercentage) { this.roiPercentage = roiPercentage; }
}
