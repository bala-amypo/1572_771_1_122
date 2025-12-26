package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "this-is-a-very-secure-secret-key-for-jwt-testing-only";

    private static final long EXPIRATION_MILLIS = 1000 * 60 * 60; // 1 hour

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // ===============================
    // GENERATE TOKEN
    // ===============================
    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===============================
    // VALIDATE TOKEN
    // ===============================
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ===============================
    // EXTRACT EMAIL
    // ===============================
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // ===============================
    // EXTRACT ROLE
    // ===============================
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ===============================
    // EXTRACT USER ID
    // ===============================
    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
