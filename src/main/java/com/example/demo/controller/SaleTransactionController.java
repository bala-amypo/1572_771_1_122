package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction sale) {
        return service.createSale(sale);
    }

    @GetMapping
    public List<SaleTransaction> getAll() {
        return service.getAllSales();
    }
}
