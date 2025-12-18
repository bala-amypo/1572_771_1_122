package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    InfluencerService influencerService;

    @GetMapping
    public List<Influencer> getAll() {
        return new ArrayList<>();
    }

    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return influencerService.creatInfluencer(influencer);
    }

    @GetMapping("/{id}")
    public Influencer getById(@PathVariable Long id) {
        return influencerService.creatInfluencer(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Influencer influencer) {
        if (influencerService.updatInfluencer(id, influencer) != null) {
            return "Successful";
        }
        return "Not successful";
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        influencerService.deactivateInfluencer(id);
        return "Successful";
    }
}
