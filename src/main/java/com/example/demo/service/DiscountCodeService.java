package com.example.demo.service;

import com.example.demo.model.DiscountCode;

import java.util.List;

public interface DiscountCodeService {

    DiscountCode getDiscountCode(long id);

    DiscountCode updateDiscountCode(long id, DiscountCode discountCode);

    List<DiscountCode> getCodesForInfluencer(long influencerId);

    List<DiscountCode> getCodesForCampaign(long campaignId);
}
