package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SaleTransaction;

public interface SaleTransactionService {
    SaleTransaction logTransaction(SaleTransaction transaction);
    SaleTransaction getTransactionById(Long id);
    SaleTransaction getSalesForCode(Long codeId);
    SaleTransaction getSalesForInfluencer(Long influencerId);
    SaleTransaction getSalesForCampaign(long campaignId);
    SaleTransaction createTransaction(SaleTransaction transaction);
    List<SaleTransaction> getAllTransactions();
    boolean deleteTransaction(Long id);
    
}