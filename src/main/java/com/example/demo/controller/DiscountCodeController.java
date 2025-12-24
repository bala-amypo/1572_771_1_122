package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public DiscountCode getById(@PathVariable Long id) {
        return service.getDiscountCodeById(id);
    }

    @GetMapping
    public List<DiscountCode> getAll() {
        return service.getAllCodes();
    }
}
