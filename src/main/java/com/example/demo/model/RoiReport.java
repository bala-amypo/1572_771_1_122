package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

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

    private BigDecimal roiPercentage;

    @Column(nullable = false, updatable = false)
    private Timestamp generatedAt;

    // =====================
    // LEGACY TEST FIELDS (HIDDEN FROM API)
    // =====================
    @JsonIgnore
    @Transient
    private Integer totalTransactions;

    @JsonIgnore
    @Transient
    private DiscountCode discountCode;

    @JsonIgnore
    @Transient
    private Double roiPercentageValue;

    @PrePersist
    protected void onCreate() {
        this.generatedAt = new Timestamp(System.currentTimeMillis());
    }

    public RoiReport() {}

    // =====================
    // GETTERS / SETTERS
    // =====================
    public Long getId() { return id; }
    public Campaign getCampaign() { return campaign; }
    public Influencer getInfluencer() { return influencer; }
    public BigDecimal getTotalSales() { return totalSales; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public BigDecimal getRoiPercentage() { return roiPercentage; }
    public Timestamp getGeneratedAt() { return generatedAt; }

    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
        this.roiPercentageValue = roiPercentage != null ? roiPercentage.doubleValue() : null;
    }

    // ===== legacy methods (tests still use them) =====
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

    public double getRoiPercentageValue() {
        return roiPercentageValue != null ? roiPercentageValue : 0.0;
    }
}
