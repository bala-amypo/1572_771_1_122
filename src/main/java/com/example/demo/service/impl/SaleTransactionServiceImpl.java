package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction sale) {
        sale.setId(1L);
        return sale;
    }

    @Override
    public List<SaleTransaction> getAllSales() {
        return List.of(new SaleTransaction(1L, 500.0));
    }
}
