package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "campaigns",
        uniqueConstraints = @UniqueConstraint(columnNames = "campaignName")
)
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal budget;

    private Boolean active = true;

    public Campaign() {}

    @PrePersist
    protected void onCreate() {
        if (this.active == null) {
            this.active = true;
        }
    }

    

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    public Boolean getActive() { return active; }

    
    public boolean isActive() {
        return active != null && active;
    }

    public void setActive(Boolean active) { this.active = active; }
}
