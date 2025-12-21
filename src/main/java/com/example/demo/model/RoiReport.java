package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Campaign campaign;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Influencer influencer;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;

    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Campaign getCampaign() { return campaign; }
    public Influencer getInfluencer() { return influencer; }
    public BigDecimal getTotalSales() { return totalSales; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public BigDecimal getRoiPercentage() { return roiPercentage; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
    public void setRoiPercentage(BigDecimal roiPercentage) { this.roiPercentage = roiPercentage; }
}
