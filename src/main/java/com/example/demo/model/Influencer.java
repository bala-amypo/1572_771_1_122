package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(
    name = "influencers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "social_handle")
    }
)
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "social_handle", nullable = false, unique = true)
    private String socialHandle;

    @Column(nullable = false)
    private boolean active = true;

    // One Influencer → Many DiscountCodes
    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiscountCode> discountCodes;

    // ✅ No-argument constructor
    public Influencer() {
    }

    // ✅ Parameterized constructor
    public Influencer(String name, String socialHandle, boolean active) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSocialHandle() {
        return socialHandle;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
