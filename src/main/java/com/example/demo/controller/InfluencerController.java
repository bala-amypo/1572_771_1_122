package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    // Get all influencers
    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }

    // Create new influencer
    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.creatInfluencer(influencer);
    }

    // Get influencer by ID
    @GetMapping("/{id}")
    public Influencer getInfluencerById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    // Update influencer
    @PutMapping("/{id}")
    public Influencer updateInfluencer(
            @PathVariable Long id,
            @RequestBody Influencer influencer) {

        return influencerService.updatInfluencer(id, influencer);
    }

    // Deactivate influencer
    @PutMapping("/{id}/deactivate")
    public String deactivateInfluencer(@PathVariable Long id) {
        influencerService.deactivateInfluencer(id);
        return "Influencer deactivated successfully";
    }
}
