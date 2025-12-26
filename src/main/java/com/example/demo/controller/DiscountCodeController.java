package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode discountCode) {
        return ResponseEntity.ok(service.create(discountCode));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(
            @PathVariable Long id,
            @RequestBody DiscountCode discountCode
    ) {
        return ResponseEntity.ok(service.update(id, discountCode));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<DiscountCode>> byInfluencer(
            @PathVariable Long influencerId
    ) {
        return ResponseEntity.ok(service.getByInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<DiscountCode>> byCampaign(
            @PathVariable Long campaignId
    ) {
        return ResponseEntity.ok(service.getByCampaign(campaignId));
    }
}
