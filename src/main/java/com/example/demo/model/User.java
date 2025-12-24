package com.example.demo.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User() {}

    public String getEmail() { return email; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setEmail(String email) { this.email = email; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
