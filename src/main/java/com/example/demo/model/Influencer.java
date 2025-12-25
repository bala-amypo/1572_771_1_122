package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "influencers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "socialHandle")
})
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSocialHandle() { return socialHandle; }
    public String getEmail() { return email; }
    public Boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }
    public void setEmail(String email) { this.email = email; }
    public void setActive(Boolean active) { this.active = active; }
}
