package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    // ✅ REQUIRED BY TEST
    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable Long id) {
        return service.getDiscountCodeById(id);
    }

    // ✅ REQUIRED BY TEST
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode discountCode
    ) {
        return service.updateDiscountCode(id, discountCode);
    }

    // ✅ REQUIRED BY TEST
    @GetMapping("/influencer/{id}")
    public List<DiscountCode> getCodesForInfluencer(@PathVariable Long id) {
        return service.getCodesForInfluencer(id);
    }

    // ✅ REQUIRED BY TEST
    @GetMapping("/campaign/{id}")
    public List<DiscountCode> getCodesForCampaign(@PathVariable Long id) {
        return service.getCodesForCampaign(id);
    }
}
