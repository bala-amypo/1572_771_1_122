package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode code);

    DiscountCode updateDiscountCode(Long id, DiscountCode code);

    DiscountCode getCodeById(Long id);

    List<DiscountCode> getAllCodes();

    List<DiscountCode> getCodesByInfluencer(Long influencerId);

    List<DiscountCode> getCodesByCampaign(Long campaignId);

    boolean deactivateCode(Long id);
}
