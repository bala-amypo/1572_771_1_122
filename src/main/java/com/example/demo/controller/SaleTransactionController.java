package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction saleTransaction) {
        return ResponseEntity.ok(saleTransactionService.createSale(saleTransaction));
    }

    @GetMapping("/code/{codeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long codeId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCode(codeId));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCampaign(campaignId));
    }
}
