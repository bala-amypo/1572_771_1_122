package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_codes", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private Double discountPercentage;
    private Boolean active = true;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    public Long getId() { return id; }
    public String getCode() { return code; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public Boolean isActive() { return active; }
    public Influencer getInfluencer() { return influencer; }
    public Campaign getCampaign() { return campaign; }

    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public void setActive(Boolean active) { this.active = active; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
}
