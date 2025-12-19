package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "campaignName"))
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal budget;

    private Boolean active = true;

    public Campaign(String campaignName, LocalDate startDate, LocalDate endDate, BigDecimal budget, Boolean active) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.active = active;
    }

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
