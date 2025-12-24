package com.example.demo.model;

public class DiscountCode {

    private Long id;
    private String code;
    private Double discount;

    // REQUIRED by Spring / Jackson
    public DiscountCode() {
    }

    // ✅ ADD THIS CONSTRUCTOR (THIS FIXES YOUR ERROR)
    public DiscountCode(Long id, String code, Double discount) {
        this.id = id;
        this.code = code;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
