// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.RoiReport;
// import com.example.demo.service.RoiService;

// @RestController
// @RequestMapping("/api/roi")
// public class RoiReportController {

//     @Autowired
//     private RoiService roiService;

//     @PostMapping("/generate/{codeId}")
//     public ResponseEntity<RoiReport> generate(@PathVariable Long codeId) {
//         return ResponseEntity.status(201)
//                 .body(roiService.generateRoiForCode(codeId));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<RoiReport> getById(@PathVariable Long id) {
//         RoiReport report = roiService.getReportById(id);
//         return report != null
//                 ? ResponseEntity.ok(report)
//                 : ResponseEntity.notFound().build();
//     }

//     @GetMapping("/influencer/{id}")
//     public ResponseEntity<List<RoiReport>> getByInfluencer(@PathVariable Long id) {
//         return ResponseEntity.ok(
//                 roiService.getReportsForInfluencer(id)
//         );
//     }

//     @GetMapping("/campaign/{id}")
//     public ResponseEntity<List<RoiReport>> getByCampaign(@PathVariable Long id) {
//         return ResponseEntity.ok(
//                 roiService.getReportsForCampaign(id)
//         );
//     }
// }
