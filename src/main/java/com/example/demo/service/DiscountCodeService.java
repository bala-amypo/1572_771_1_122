package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode discountCode);

    // ✅ REQUIRED by test
    DiscountCode getDiscountCodeById(long id);

    List<DiscountCode> getCodesByInfluencer(long influencerId);

    List<DiscountCode> getCodesByCampaign(long campaignId);

    DiscountCode updateDiscountCode(long id, DiscountCode discountCode);

    void deactivateDiscountCode(long id);
}
