package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    public ResponseEntity<DiscountCode> getDiscountCode(Long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    public ResponseEntity<DiscountCode> updateDiscountCode(Long id, DiscountCode dc) {
        return ResponseEntity.ok(service.updateDiscountCode(id, dc));
    }

    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(Long id) {
        return ResponseEntity.ok(service.getCodesForInfluencer(id));
    }

    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(Long id) {
        return ResponseEntity.ok(service.getCodesForCampaign(id));
    }
}
