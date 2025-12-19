package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.de.model.Influencer;
import com.example.ROI.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    InfluencerService service;

    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return service.createInfluencer(influencer);
    }

    @PutMapping("/{id}")
    public Influencer update(@PathVariable Long id, @RequestBody Influencer influencer) {
        return service.updateInfluencer(id, influencer);
    }

    @GetMapping("/{id}")
    public Influencer get(@PathVariable Long id) {
        return service.getInfluencerById(id);
    }

    @GetMapping
    public List<Influencer> getAll() {
        return service.getAllInfluencers();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return service.deactivateInfluencer(id) ? "Deactivated" : "Not Found";
    }
}
