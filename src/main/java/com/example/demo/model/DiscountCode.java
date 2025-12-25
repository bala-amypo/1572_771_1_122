package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "discount_codes",
        uniqueConstraints = @UniqueConstraint(columnNames = "code")
)
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Double discountPercentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    public DiscountCode() {}

    @PrePersist
    protected void onCreate() {
        if (this.active == null) {
            this.active = true;
        }
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // ✅ REQUIRED BY TEST
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Boolean getActive() { return active; }

    // ✅ REQUIRED BY TEST
    public boolean isActive() {
        return active != null && active;
    }

    public void setActive(Boolean active) { this.active = active; }
}
