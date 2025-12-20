package com.example.demo.controller;


import org.jspecify.annotations.Nullable;
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

    // -------------------------------
    // POST / - Create discount code
    // -------------------------------
    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(
            @RequestBody DiscountCode code) {

        DiscountCode savedCode = discountCodeService.createDiscountCode(code);
        return ResponseEntity.status(201).body(savedCode);
    }

    // -------------------------------
    // PUT /{id} - Update discount code
    // -------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {

        DiscountCode updated = discountCodeService.updateDiscountCode(id, code);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // -------------------------------
    // GET /{id} - Get code by ID
    // -------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getCodeById(@PathVariable Long id) {

        DiscountCode code = discountCodeService.getCodeById(id);
        if (code != null) {
            return ResponseEntity.ok(code);
        }
        return ResponseEntity.notFound().build();
    }

    // --------------------------------------------------
    // GET /influencer/{influencerId} - List codes by influencer
    // --------------------------------------------------
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<@Nullable Object> getCodesByInfluencer(
            @PathVariable Long influencerId) {

        return ResponseEntity.ok(
                discountCodeService.getCodesByInfluencer(influencerId)
        );
    }

    // --------------------------------------------------
    // GET /campaign/{campaignId} - List codes by campaign
    // --------------------------------------------------
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<@Nullable Object> getCodesByCampaign(
            @PathVariable Long campaignId) {

        return ResponseEntity.ok(
                discountCodeService.getCodesByCampaign(campaignId)
        );
    }

    // --------------------------------
    // PUT /{id}/deactivate - Deactivate code
    // --------------------------------
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateCode(@PathVariable Long id) {

        boolean deactivated = discountCodeService.deactivateCode(id);
        if (deactivated) {
            return ResponseEntity.ok("Discount code deactivated successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
