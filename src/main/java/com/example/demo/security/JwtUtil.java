package com.example.demo.security;

public class JwtUtil {
    public String generateToken(String email, String role, Long userId) { return ""; }
    public boolean validateToken(String token) { return true; }
    public String extractEmail(String token) { return ""; }
    public String extractRole(String token) { return ""; }
    public Long extractUserId(String token) { return 0L; }
}
