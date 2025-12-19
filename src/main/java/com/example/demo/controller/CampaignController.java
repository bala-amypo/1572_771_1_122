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
    CampaignService campaignService;

    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.getAllCampaigns();
    }

    @PostMapping
    public ResponseEntity<Campaign> createAll(@RequestBody Campaign campaign) {
        Campaign cp = campaignService.createCampaign(campaign);
        return ResponseEntity.status(201).body(cp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getById(@PathVariable Long id) {
        Campaign cp = campaignService.getCampaignById(id);
        return ResponseEntity.status(200).body(cp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putAll(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {

        if (campaignService.updateCampaign(id, campaign) != null) {
            return ResponseEntity.status(201).body("Successful");
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        boolean isDeactivated = campaignService.deactivateCampaign(id);
        if (isDeactivated) {
            return ResponseEntity.status(201).body("Successful");
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
