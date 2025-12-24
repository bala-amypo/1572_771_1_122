package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;  // ✅ variable declared

    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer influencer) {
        return ResponseEntity.ok(influencerService.createInfluencer(influencer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(@PathVariable Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }
}
