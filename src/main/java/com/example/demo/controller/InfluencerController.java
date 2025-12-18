package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    @PutMapping("/{id}")
    public Influencer update(@PathVariable Long id, @RequestBody Influencer influencer) {
        return influencerService.updateInfluencer(id, influencer);
    }

    @GetMapping("/{id}")
    public Influencer getById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    @GetMapping
    public List<Influencer> getAll() {
        return influencerService.getAllInfluencers();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        influencerService.deactivateInfluencer(id);
        return ResponseEntity.ok("Influencer deactivated");
    }
}
