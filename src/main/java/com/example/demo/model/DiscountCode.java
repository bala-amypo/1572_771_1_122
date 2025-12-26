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

    @Column(nullable = false, unique = true)
    private String code; // ✅ MUST be "code"

    private Double discountPercentage;

    private Boolean active = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    public DiscountCode() {}

    // -------- GETTERS & SETTERS --------

    public Long getId() {
        return id;
    }

    public String getCode() {          // ✅ REQUIRED BY TESTS
        return code;
    }

    public void setCode(String code) { // ✅ REQUIRED BY TESTS
        this.code = code;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
