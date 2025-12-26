package com.example.demo.service;

import com.example.demo.model.DiscountCode;

import java.util.List;

public interface DiscountCodeService {

    DiscountCode create(DiscountCode discountCode);

    DiscountCode getById(Long id);

    DiscountCode update(Long id, DiscountCode discountCode);

    void deactivate(Long id);

    List<DiscountCode> getByInfluencer(Long influencerId);

    List<DiscountCode> getByCampaign(Long campaignId);
}
