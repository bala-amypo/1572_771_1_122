package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SaleTransaction;

public interface SaleTransactionService {

    SaleTransaction logTransaction(SaleTransaction transaction);

    SaleTransaction getTransactionById(Long id);

    List<SaleTransaction> getSalesForCode(Long codeId);

    List<SaleTransaction> getSalesForInfluencer(Long influencerId);

    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
