package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "discount_codes",
        uniqueConstraints = @UniqueConstraint(columnNames = "code_value")
)
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_value", nullable = false, unique = true)
    private String codeValue;

    private Double discountPercentage;

    private Boolean active = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    public DiscountCode() {}

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodeValue() { return codeValue; }
    public void setCodeValue(String codeValue) { this.codeValue = codeValue; }

    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Boolean getActive() { return active; }

    public boolean isActive() {
        return active != null && active;
    }

    public void setActive(Boolean active) { this.active = active; }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
