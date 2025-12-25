package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Influencer> create(@RequestBody Influencer influencer) {
        return ResponseEntity.ok(service.createInfluencer(influencer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Influencer> update(@PathVariable Long id,
                                             @RequestBody Influencer influencer) {
        return ResponseEntity.ok(service.updateInfluencer(id, influencer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInfluencer(id));
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> list() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}
