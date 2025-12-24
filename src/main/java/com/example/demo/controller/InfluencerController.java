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

    // ✅ Constructor injection (Mockito-friendly)
    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // 🔹 Create Influencer
    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(
            @RequestBody Influencer influencer) {

        Influencer saved = influencerService.createInfluencer(influencer);
        return ResponseEntity.ok(saved);
    }

    // 🔹 Get Influencer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(
            @PathVariable Long id) {

        Influencer influencer = influencerService.getInfluencerById(id);
        return ResponseEntity.ok(influencer);
    }

    // 🔹 Get all Influencers
    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {

        List<Influencer> influencers = influencerService.getAllInfluencers();
        return ResponseEntity.ok(influencers);
    }

    // 🔹 Update Influencer
    @PutMapping("/{id}")
    public ResponseEntity<Influencer> updateInfluencer(
            @PathVariable Long id,
            @RequestBody Influencer influencer) {

        Influencer updated = influencerService.updateInfluencer(id, influencer);
        return ResponseEntity.ok(updated);
    }

    // 🔹 Delete Influencer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInfluencer(
            @PathVariable Long id) {

        influencerService.deleteInfluencer(id);
        return ResponseEntity.ok("Influencer deleted successfully");
    }
}
