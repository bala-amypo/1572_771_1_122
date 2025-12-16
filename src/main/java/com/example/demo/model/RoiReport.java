package com.example.demo.model;

import java.math.BigDecimal;
import java.security.Timestamp;

public class RoiReport {
    private Long id;
    private Campaign campaign;
    private Influencer influencer;
    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;
    private Timestamp generatedAt;
    public RoiReport(Campaign campaign, Influencer influencer, BigDecimal totalSales, BigDecimal totalRevenue,
            BigDecimal roiPercentage, Timestamp generatedAt) {
        this.campaign = campaign;
        this.influencer = influencer;
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.roiPercentage = roiPercentage;
        this.generatedAt = generatedAt;
    }
    public Long getId() {
        return id;
    }
    public Campaign getCampaign() {
        return campaign;
    }
    public Influencer getInfluencer() {
        return influencer;
    }
    public BigDecimal getTotalSales() {
        return totalSales;
    }
    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
    public BigDecimal getRoiPercentage() {
        return roiPercentage;
    }
    public Timestamp getGeneratedAt() {
        return generatedAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }
    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }
    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }
    public void setGeneratedAt(Timestamp generatedAt) {
        this.generatedAt = generatedAt;
    }
    

    
}
