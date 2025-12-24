package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {
    private DiscountCode discountCode;
    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalTransactions() { return totalTransactions; }
    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public double getRoiPercentage() { return roiPercentage; }
    public void setRoiPercentage(double roiPercentage) {
        this.roiPercentage = roiPercentage;
    }
}
