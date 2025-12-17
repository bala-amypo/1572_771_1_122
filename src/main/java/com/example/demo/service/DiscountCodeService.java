package com.example.demo.service;

import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {
    DiscountCode creaDiscountCode(DiscountCode code);
    DiscountCode updaDiscountCode(Long id,DiscountCode code);
    DiscountCode getCodeById(Long id);
    DiscountCode getCodesByInfluencer(Long influencerId);
    DiscountCode getCodesByCampaign(Long campaignId);
    void deactivateCode(Long id);

    
} 