package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode discountCode);

    DiscountCode getDiscountCodeById(Long id);

    DiscountCode updateDiscountCode(Long id, DiscountCode discountCode);

    DiscountCode deactivateDiscountCode(Long id);

    List<DiscountCode> getCodesForInfluencer(Long influencerId);

    List<DiscountCode> getCodesForCampaign(Long campaignId);
}
