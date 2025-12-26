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

    // Nullable ManyToOne Campaign
    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = true)
    private Campaign campaign;

    // Nullable ManyToOne Influencer
    @ManyToOne
    @JoinColumn(name = "influencer_id", nullable = true)
    private Influencer influencer;

    @Column(nullable = false)
    private BigDecimal totalSales;

    @Column(nullable = false)
    private BigDecimal totalRevenue;

    @Column(nullable = false)
    private BigDecimal roiPercentage;

    @Column(nullable = false, updatable = false)
    private Timestamp generatedAt;

    // ✅ Auto-generate timestamp
    @PrePersist
    protected void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    // Constructors
    public RoiReport() {}

    public RoiReport(Campaign campaign,
                     Influencer influencer,
                     BigDecimal totalSales,
                     BigDecimal totalRevenue,
                     BigDecimal roiPercentage) {
        this.campaign = campaign;
        this.influencer = influencer;
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.roiPercentage = roiPercentage;
    }

    // Getters & Setters
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
}
