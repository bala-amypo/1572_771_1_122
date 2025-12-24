package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {
    private Long id;
    private DiscountCode discountCode;
    private BigDecimal totalSales;
    private Integer totalTransactions;
    private Double roiPercentage;

    public RoiReport() {}

    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTotalSales() { return totalSales; }
    public Integer getTotalTransactions() { return totalTransactions; }
    public Double getRoiPercentage() { return roiPercentage; }

    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(Integer totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(Double roiPercentage) { this.roiPercentage = roiPercentage; }
}
