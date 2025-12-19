package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/api/sale-transactions")
public class SaleTransactionController {

    @Autowired
    SaleTransactionService saleTransactionService;

    @GetMapping
    public List<SaleTransaction> getAll() {
        return saleTransactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createAll(@RequestBody SaleTransaction transaction) {
        SaleTransaction st = saleTransactionService.createTransaction(transaction);
        return ResponseEntity.status(201).body(st);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleTransaction> getById(@PathVariable Long id) {
        SaleTransaction st = saleTransactionService.getTransactionById(id);
        return ResponseEntity.status(200).body(st);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAll(@PathVariable Long id) {
        boolean isDeleted = saleTransactionService.deleteTransaction(id);
        if (isDeleted) {
            return ResponseEntity.status(201).body("Successful");
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
