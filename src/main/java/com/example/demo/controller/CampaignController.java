package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAll() {
        return ResponseEntity.ok(campaignService.getAllCampaigns());
    }

    @PostMapping
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaign) {
        Campaign savedCampaign = campaignService.createCampaign(campaign);
        return ResponseEntity.status(201).body(savedCampaign);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getById(@PathVariable Long id) {
        Campaign campaign = campaignService.getCampaignById(id);
        if (campaign != null) {
            return ResponseEntity.ok(campaign);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {

        Campaign updated = campaignService.updateCampaign(id, campaign);
        if (updated != null) {
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        if (campaignService.deactivateCampaign(id)) {
            return ResponseEntity.ok("Deactivated Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
