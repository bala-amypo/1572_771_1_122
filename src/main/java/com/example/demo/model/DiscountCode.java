package com.example.ROI.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discount_codes")
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeValue;
    private Double discountPercentage;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @OneToMany(mappedBy = "discountCode", cascade = CascadeType.ALL)
    private List<SaleTransaction> sales = new ArrayList<>();

    public DiscountCode() {}

    public DiscountCode(String codeValue, Double discountPercentage) {
        this.codeValue = codeValue;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() { return id; }
    public String getCodeValue() { return codeValue; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public Influencer getInfluencer() { return influencer; }
    public Campaign getCampaign() { return campaign; }
    public List<SaleTransaction> getSales() { return sales; }

    public void setId(Long id) { this.id = id; }
    public void setCodeValue(String codeValue) { this.codeValue = codeValue; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public void setSales(List<SaleTransaction> sales) { this.sales = sales; }
}
