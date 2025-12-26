package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(roiService.getReportsForInfluencer(influencerId));
    }

    // ✅ POST ADDED
    @PostMapping("/generate/{codeId}")
    public ResponseEntity<RoiReport> generateRoiReport(
            @PathVariable Long codeId) {
        return ResponseEntity.ok(roiService.generateRoiReport(codeId));
    }
}
