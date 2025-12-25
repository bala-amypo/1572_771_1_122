package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;

    public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction saleTransaction) {
        if (saleTransaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }

        if (saleTransaction.getTransactionDate() == null) {
            saleTransaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        }

        return saleTransactionRepository.save(saleTransaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
    }
}
