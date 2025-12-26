package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    // =====================
    // PRIMARY KEY
    // =====================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =====================
    // SPEC FIELDS (PERSISTED)
    // =====================
    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = true)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "influencer_id", nullable = true)
    private Influencer influencer;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;

    // SPEC ROI (DB-safe)
    private BigDecimal roiPercentage;

    @Column(nullable = false, updatable = false)
    private Timestamp generatedAt;

    // =====================
    // LEGACY TEST FIELDS (NOT PERSISTED)
    // =====================
    @Transient
    private Integer totalTransactions;

    @Transient
    private DiscountCode discountCode;

    // Legacy ROI for tests (double)
    @Transient
    private Double roiPercentageValue;

    // =====================
    // AUTO TIMESTAMP
    // =====================
    @PrePersist
    protected void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    // =====================
    // CONSTRUCTORS
    // =====================
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
        this.roiPercentageValue = roiPercentage != null ? roiPercentage.doubleValue() : null;
    }

    // =====================
    // SPEC GETTERS / SETTERS
    // =====================
    public Long getId() { return id; }

    public Campaign getCampaign() { return campaign; }

    public Influencer getInfluencer() { return influencer; }

    public BigDecimal getTotalSales() { return totalSales; }

    public BigDecimal getTotalRevenue() { return totalRevenue; }

    public BigDecimal getRoiPercentageDecimal() {
        return roiPercentage;
    }

    public Timestamp getGeneratedAt() { return generatedAt; }

    public void setCampaign(Campaign campaign) { this.campaign = campaign; }

    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }

    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }

    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
        this.roiPercentageValue = roiPercentage != null ? roiPercentage.doubleValue() : null;
    }

    // =====================
    // LEGACY TEST METHODS (REQUIRED)
    // =====================
    public int getTotalTransactions() {
        return totalTransactions != null ? totalTransactions : 0;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    // 🔥 THIS FIXES LINE 336
    public double getRoiPercentage() {
        return roiPercentageValue != null ? roiPercentageValue : 0.0;
    }

    public void setRoiPercentage(double roiPercentage) {
        this.roiPercentageValue = roiPercentage;
        this.roiPercentage = BigDecimal.valueOf(roiPercentage);
    }
}
