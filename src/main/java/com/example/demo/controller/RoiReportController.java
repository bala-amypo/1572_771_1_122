package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

@RestController
@RequestMapping("/api/roi")
@SecurityRequirement(name="bearerAuth")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/generate/{codeId}")
    public ResponseEntity<RoiReport> generateRoiReport(
            @PathVariable Long codeId) {
        return ResponseEntity.ok(roiService.generateRoiReport(codeId));
    }

    @GetMapping("{id}")
    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(
            @PathVariable Long influencerId) {
        return ResponseEntity.ok(roiService.getReportsForInfluencer(influencerId));
    }
}
