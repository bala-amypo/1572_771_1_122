package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    // Constructor injection (Mockito-friendly)
    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // Create Influencer
    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(
            @RequestBody Influencer influencer) {

        return ResponseEntity.ok(
                influencerService.createInfluencer(influencer)
        );
    }

    // Get Influencer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                influencerService.getInfluencerById(id)
        );
    }

    // Get All Influencers
    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {

        return ResponseEntity.ok(
                influencerService.getAllInfluencers()
        );
    }
}
