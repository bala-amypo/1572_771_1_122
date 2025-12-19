package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(
    name = "campaign",
    uniqueConstraints = @UniqueConstraint(columnNames = "campaign_name")
)
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campaign_name", nullable = false, unique = true)
    private String campaignName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(precision = 38, scale = 2)
    private BigDecimal budget;

    @Column(columnDefinition = "bit(1)")
    private Boolean active = true;

    // ✅ REQUIRED: No-args constructor
    public Campaign() {
    }

    public Campaign(String campaignName, LocalDate startDate,
                    LocalDate endDate, BigDecimal budget, Boolean active) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
