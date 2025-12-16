package com.example.demo.model;

import java.sql.Timestamp;

public class Influencer {
    private Long id;
    private String name;
    private String socialHandle;
    private String email;
    private Boolean active;
    private Timestamp createdAt;
    public Influencer(String name, String socialHandle, String email, Boolean active, Timestamp createdAt) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSocialHandle() {
        return socialHandle;
    }
    public String getEmail() {
        return email;
    }
    public Boolean getActive() {
        return active;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
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
    public void setEmail(String email) {
        this.email = email;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
