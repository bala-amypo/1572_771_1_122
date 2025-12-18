package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    // ✅ Constructor injection
    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    /**
     * POST /influencers
     * Create a new influencer
     */
    @PostMapping
    @PreAuthorize("isAuthenticated()") // 🔐 JWT protected
    public ResponseEntity<Influencer> createInfluencer(
            @RequestBody Influencer influencer) {

        Influencer created = influencerService.createInfluencer(influencer);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * GET /influencers
     * Get all influencers
     */
    @GetMapping
    @PreAuthorize("isAuthenticated()") // 🔐 JWT protected
    public ResponseEntity<List<Influencer>> getAllInfluencers() {

        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }

    /**
     * GET /influencers/{id}
     * Get influencer by id
     * ResourceNotFoundException is allowed to propagate
     */
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()") // 🔐 JWT protected
    public ResponseEntity<Influencer> getInfluencerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }
}
