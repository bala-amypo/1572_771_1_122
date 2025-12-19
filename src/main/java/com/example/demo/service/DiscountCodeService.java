package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {
    DiscountCode creaDiscountCode(DiscountCode code);
    DiscountCode updaDiscountCode(Long id,DiscountCode code);
    DiscountCode getCodeById(Long id);
    DiscountCode getCodesByInfluencer(Long influencerId);
    DiscountCode getCodesByCampaign(Long campaignId);
    boolean deactivateCode(Long id);
    DiscountCode createDiscountCode(DiscountCode code);
    List<DiscountCode> getAllCodes();
    DiscountCode updateDiscountCode(Long id, DiscountCode updatedCode);

    
} 