package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_codes")
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Double discountPercentage;

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    public DiscountCode() {}

    public Long getId() { return id; }
    public String getCode() { return code; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public Campaign getCampaign() { return campaign; }
    public Influencer getInfluencer() { return influencer; }

    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
}
