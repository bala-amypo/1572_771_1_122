// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Influencer;
// import com.example.demo.service.InfluencerService;

// @RestController
// @RequestMapping("/api/influencers")
// public class InfluencerController {

//     @Autowired
//     private InfluencerService influencerService;

//     @PostMapping
//     public Influencer createInfluencer(@RequestBody Influencer influencer) {
//         return influencerService.createInfluencer(influencer);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<String> updateInfluencer(
//             @PathVariable Long id,
//             @RequestBody Influencer influencer) {

//         Influencer updated = influencerService.updateInfluencer(id, influencer);
//         if (updated != null) {
//             return ResponseEntity.ok("Influencer updated successfully");
//         }
//         return ResponseEntity.badRequest().body("Influencer not found");
//     }

//     @GetMapping("/{id}")
//     public Influencer getInfluencerById(@PathVariable Long id) {
//         return influencerService.getInfluencerById(id);
//     }

//     @GetMapping
//     public List<Influencer> getAllInfluencers() {
//         return influencerService.getAllInfluencers();
//     }

//     @PutMapping("/{id}/deactivate")
//     public ResponseEntity<String> deactivateInfluencer(@PathVariable Long id) {
//         influencerService.deactivateInfluencer(id);
//         return ResponseEntity.ok("Influencer deactivated");
//     }
// }
