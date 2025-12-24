package com.example.demo.model;

import java.time.LocalDateTime;

public class User {
    private String email;
    private LocalDateTime createdAt;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
