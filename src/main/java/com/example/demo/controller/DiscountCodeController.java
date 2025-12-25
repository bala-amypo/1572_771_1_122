package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode dc) {
        return ResponseEntity.ok(discountCodeService.createDiscountCode(dc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(
            @PathVariable Long id,
            @RequestBody DiscountCode dc) {
        return ResponseEntity.ok(discountCodeService.updateDiscountCode(id, dc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> get(@PathVariable Long id) {
        return ResponseEntity.ok(discountCodeService.getDiscountCodeById(id));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> byInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(discountCodeService.getCodesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> byCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(discountCodeService.getCodesForCampaign(campaignId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        discountCodeService.deactivateDiscountCode(id);
        return ResponseEntity.noContent().build();
    }
}
