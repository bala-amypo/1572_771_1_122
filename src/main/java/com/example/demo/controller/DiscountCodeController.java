package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    // POST /api/discount-codes
    @PostMapping
    public DiscountCode create(@RequestBody DiscountCode discountCode) {
        return service.createDiscountCode(discountCode);
    }

    // PUT /api/discount-codes/{id}
    @PutMapping("/{id}")
    public DiscountCode update(
            @PathVariable Long id,
            @RequestBody DiscountCode discountCode) {
        return service.updateDiscountCode(id, discountCode);
    }

    // GET /api/discount-codes/{id}
    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable Long id) {
        return service.getDiscountCode(id);
    }

    // GET /api/discount-codes/influencer/{influencerId}
    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesForInfluencer(
            @PathVariable Long influencerId) {
        return service.getCodesForInfluencer(influencerId);
    }

    // GET /api/discount-codes/campaign/{campaignId}
    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesForCampaign(
            @PathVariable Long campaignId) {
        return service.getCodesForCampaign(campaignId);
    }

    // PUT /api/discount-codes/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public DiscountCode deactivate(@PathVariable Long id) {
        return service.deactivateDiscountCode(id);
    }
}
