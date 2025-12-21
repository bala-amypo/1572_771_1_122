package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nullable by default
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Campaign campaign;

    // Nullable by default
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Influencer influencer;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;

    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public RoiReport() {}

    // getters & setters
}
