package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    public ResponseEntity<Campaign> updateCampaign(Long id, Campaign c) {
        return ResponseEntity.ok(service.updateCampaign(id, c));
    }

    public ResponseEntity<Campaign> getCampaign(Long id) {
        return ResponseEntity.ok(service.getCampaignById(id));
    }

    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return ResponseEntity.ok(service.getAllCampaigns());
    }
}
