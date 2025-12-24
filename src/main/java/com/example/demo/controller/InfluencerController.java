package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    public ResponseEntity<Influencer> createInfluencer(Influencer influencer) {
        return ResponseEntity.ok(influencerService.createInfluencer(influencer));
    }

    public ResponseEntity<Influencer> getInfluencer(Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }
}
