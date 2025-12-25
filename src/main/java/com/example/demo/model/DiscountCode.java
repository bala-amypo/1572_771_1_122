package com.example.demo.model;

public class DiscountCode {

    private Long id;
    private String code;
    private double discountPercentage;
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // REQUIRED BY SERVICE
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // REQUIRED BY SERVICE
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
