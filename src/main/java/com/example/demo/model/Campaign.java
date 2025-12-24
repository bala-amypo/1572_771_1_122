package com.example.demo.model;

import java.time.LocalDate;

public class Campaign {
    private Long id;
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Campaign() {}

    public Campaign(String campaignName, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() { return id; }
    public String getCampaignName() { return campaignName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public void setId(Long id) { this.id = id; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
