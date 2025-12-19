package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Influencer influencer;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Campaign campaign;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(columnDefinition = "bit(1)")
    private Boolean active = true;

    public DiscountCode() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
