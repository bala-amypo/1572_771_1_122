package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    @Autowired
    private SaleTransactionService saleTransactionService;

    // POST / - Log sale transaction
    @PostMapping
    public ResponseEntity<SaleTransaction> logTransaction(
            @RequestBody SaleTransaction transaction) {

        return ResponseEntity.status(201)
                .body(saleTransactionService.logTransaction(transaction));
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<SaleTransaction> getById(@PathVariable Long id) {
        SaleTransaction tx = saleTransactionService.getTransactionById(id);
        if (tx == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tx);
    }

    // GET /code/{codeId}
    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return saleTransactionService.getSalesForCode(codeId);
    }

    // GET /influencer/{influencerId}
    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getByInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    // GET /campaign/{campaignId}
    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getByCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
}
