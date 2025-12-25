package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<DiscountCode> discountCodes = new ArrayList<>();

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
    public List<DiscountCode> getDiscountCodes() { return discountCodes; }

    public void setId(Long id) { this.id = id; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setDiscountCodes(List<DiscountCode> discountCodes) { this.discountCodes = discountCodes; }
}
