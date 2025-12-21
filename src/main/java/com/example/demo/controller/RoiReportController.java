package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    @Autowired
    private RoiService roiService;

    // POST /api/roi/generate/{codeId}
    @PostMapping("/generate/{codeId}")
    public ResponseEntity<RoiReport> generateRoi(
            @PathVariable Long codeId) {

        RoiReport report = roiService.generateRoiForCode(codeId);
        return ResponseEntity.status(201).body(report);
    }

    // GET /api/roi/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RoiReport> getById(@PathVariable Long id) {

        RoiReport report = roiService.getReportById(id);
        return ResponseEntity.ok(report);
    }

    // GET /api/roi/influencer/{influencerId}
    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<RoiReport>> getByInfluencer(
            @PathVariable Long influencerId) {

        return ResponseEntity.ok(
                roiService.getReportsForInfluencer(influencerId)
        );
    }

    // GET /api/roi/campaign/{campaignId}
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<RoiReport>> getByCampaign(
            @PathVariable Long campaignId) {

        return ResponseEntity.ok(
                roiService.getReportsForCampaign(campaignId)
        );
    }
}
