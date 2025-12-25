package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final List<DiscountCode> codes = new ArrayList<>();

    @Override
    public DiscountCode getDiscountCode(long id) {
        return codes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public DiscountCode updateDiscountCode(long id, DiscountCode discountCode) {
        DiscountCode existing = getDiscountCode(id);
        if (existing != null) {
            existing.setCode(discountCode.getCode());
            existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        }
        return existing;
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(long influencerId) {
        return codes;
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(long campaignId) {
        return codes;
    }
}
