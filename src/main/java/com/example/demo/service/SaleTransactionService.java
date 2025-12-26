package com.example.ROI.service;

import com.example.ROI.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {

    SaleTransaction createSale(SaleTransaction saleTransaction);

    List<SaleTransaction> getSalesForCode(Long discountCodeId);

    List<SaleTransaction> getSalesForInfluencer(Long influencerId);

    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
