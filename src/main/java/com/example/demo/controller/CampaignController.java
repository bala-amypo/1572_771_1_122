package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @GetMapping
    public List<Campaign> getAll() {
        return new ArrayList<>();
    }

    @PostMapping
    public Campaign create(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping("/{id}")
    public Campaign getById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Campaign campaign) {
        if (campaignService.updateCampaign(id, campaign) != null) {
            return "Successful";
        }
        return "Not successful";
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        campaignService.deactivateCampaign(id);
        return "Successful";
    }
}
