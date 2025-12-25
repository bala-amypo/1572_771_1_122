package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private boolean active = true;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    private List<DiscountCode> discountCodes = new ArrayList<>();

    public Influencer() {}

    public Influencer(String name, String socialHandle, boolean active) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSocialHandle() { return socialHandle; }
    public boolean isActive() { return active; }
    public List<DiscountCode> getDiscountCodes() { return discountCodes; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }
    public void setActive(boolean active) { this.active = active; }
    public void setDiscountCodes(List<DiscountCode> discountCodes) { this.discountCodes = discountCodes; }
}
