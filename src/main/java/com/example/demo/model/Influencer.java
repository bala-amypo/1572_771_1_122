package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String niche; // e.g., fashion, fitness, tech

    @NotBlank(message = "Platform is required")
    private String platform; // e.g., Instagram, TikTok, YouTube

    private String profileUrl;

    @NotNull
    private Boolean active = true;

    @GeneratedValue // Note: Timestamp will be set manually or via DB default
    private Timestamp createdAt;

    public Influencer() {}

    public Influencer(String username, String fullName, String niche, String platform,
                      String profileUrl, Boolean active, Timestamp createdAt) {
        this.username = username;
        this.fullName = fullName;
        this.niche = niche;
        this.platform = platform;
        this.profileUrl = profileUrl;
        this.active = active;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getNiche() { return niche; }
    public void setNiche(String niche) { this.niche = niche; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getProfileUrl() { return profileUrl; }
    public void setProfileUrl(String profileUrl) { this.profileUrl = profileUrl; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}