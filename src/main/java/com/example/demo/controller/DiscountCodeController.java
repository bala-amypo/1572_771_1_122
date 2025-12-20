package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    @Autowired
    private DiscountCodeService discountCodeService;

    // POST / - Create discount code
    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode code) {
        return ResponseEntity.status(201)
                .body(discountCodeService.createDiscountCode(code));
    }

    // PUT /{id} - Update discount code
    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {

        DiscountCode updated = discountCodeService.updateDiscountCode(id, code);
        if (updated == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getById(@PathVariable Long id) {
        DiscountCode code = discountCodeService.getCodeById(id);
        if (code == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(code);
    }

    // GET /influencer/{influencerId}
    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getByInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getCodesByInfluencer(influencerId);
    }

    // GET /campaign/{campaignId}
    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getByCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getCodesByCampaign(campaignId);
    }

    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        if (discountCodeService.deactivateCode(id)) {
            return ResponseEntity.ok("Discount code deactivated");
        }
        return ResponseEntity.notFound().build();
    }
}
