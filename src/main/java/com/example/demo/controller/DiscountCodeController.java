package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    @Autowired
    DiscountCodeService discountCodeService;

    @GetMapping
    public List<DiscountCode> getAll() {
        return discountCodeService.getAllCodes();
    }

    @PostMapping
    public ResponseEntity<DiscountCode> createAll(@RequestBody DiscountCode code) {
        DiscountCode dc = discountCodeService.createDiscountCode(code);
        return ResponseEntity.status(201).body(dc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getById(@PathVariable Long id) {
        DiscountCode dc = discountCodeService.getCodeById(id);
        return ResponseEntity.status(200).body(dc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putAll(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {

        if (discountCodeService.updaDiscountCode(id, code) != null) {
            return ResponseEntity.status(201).body("Successful");
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        boolean isDeactivated = discountCodeService.deactivateCode(id);
        if (isDeactivated) {
            return ResponseEntity.status(201).body("Successful");
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
