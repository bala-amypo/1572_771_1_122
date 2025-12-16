package com.example.demo.model;

public class DiscountCode {
    private Long id;
    private String code;
    private Influencer influencer;
    private Campaign campaign;
    private Double discountPercentage;
    private Boolean active;
    public DiscountCode(String code, Influencer influencer, Campaign campaign, Double discountPercentage,
            Boolean active) {
        this.code = code;
        this.influencer = influencer;
        this.campaign = campaign;
        this.discountPercentage = discountPercentage;
        this.active = active;
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
