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

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode discountCode) {
        return service.createDiscountCode(discountCode);
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable long id) {
        return service.getDiscountCodeById(id);
    }

    // ✅ REQUIRED by test (NAME + SIGNATURE)
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable long id,
            @RequestBody DiscountCode discountCode) {
        return service.updateDiscountCode(id, discountCode);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateDiscountCode(@PathVariable long id) {
        service.deactivateDiscountCode(id);
    }

    @GetMapping("/influencer/{id}")
    public List<DiscountCode> getByInfluencer(@PathVariable long id) {
        return service.getCodesByInfluencer(id);
    }

    @GetMapping("/campaign/{id}")
    public List<DiscountCode> getByCampaign(@PathVariable long id) {
        return service.getCodesByCampaign(id);
    }
}
