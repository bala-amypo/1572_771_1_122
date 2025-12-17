package com.example.demo.service;

import com.example.demo.model.SaleTransaction;

public interface SaleTransactionService {
    SaleTransaction logTransaction(SaleTransaction transaction);
    SaleTransaction getTransactionById(Long id);
    SaleTransaction getSalesForCode(Long codeId);
    SaleTransaction getSalesForInfluencer(Long influencerId);
    SaleTransaction getSalesForCampaign(long campaignId);
    
}