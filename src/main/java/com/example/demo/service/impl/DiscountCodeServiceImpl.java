package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeServiceImpl(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode discountCode) {
        return repository.save(discountCode);
    }

    // ✅ REQUIRED by test
    @Override
    public DiscountCode getDiscountCodeById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(long influencerId) {
        return repository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(long campaignId) {
        return repository.findByCampaignId(campaignId);
    }

    @Override
    public DiscountCode updateDiscountCode(long id, DiscountCode discountCode) {
        DiscountCode existing = getDiscountCodeById(id);
        existing.setCodeValue(discountCode.getCodeValue());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        return repository.save(existing);
    }

    @Override
    public void deactivateDiscountCode(long id) {
        DiscountCode dc = getDiscountCodeById(id);
        dc.setActive(false);
        repository.save(dc);
    }
}
