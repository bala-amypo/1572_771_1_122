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
    private DiscountCodeService discountCodeService;

    @GetMapping
    public ResponseEntity<List<DiscountCode>> getAll() {
        return ResponseEntity.ok(discountCodeService.getAllCodes());
    }

    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode code) {
        return ResponseEntity.status(201)
                .body(discountCodeService.createDiscountCode(code));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getById(@PathVariable Long id) {
        DiscountCode code = discountCodeService.getCodeById(id);
        if (code != null) {
            return ResponseEntity.ok(code);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {

        DiscountCode updated = discountCodeService.updateDiscountCode(id, code);
        if (updated != null) {
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        if (discountCodeService.deactivateCode(id)) {
            return ResponseEntity.ok("Deactivated Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
