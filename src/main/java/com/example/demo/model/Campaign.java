package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Campaign {
    private Long id;
    private String campaignName;
    private Date startDate;
    private Date endDate;
    private BigDecimal budget;
    private Boolean active;
    public Campaign(String campaignName, Date startDate, Date endDate, BigDecimal budget, Boolean active) {
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
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
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
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    

    
}
