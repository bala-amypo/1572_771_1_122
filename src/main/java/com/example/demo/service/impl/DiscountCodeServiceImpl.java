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
        discountCode.setActive(true);
        return repository.save(discountCode);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
        DiscountCode existing = getDiscountCode(id);
        existing.setCode(updated.getCode());
        existing.setDiscountPercentage(updated.getDiscountPercentage());
        existing.setInfluencer(updated.getInfluencer());
        existing.setCampaign(updated.getCampaign());
        return repository.save(existing);
    }

    @Override
    public DiscountCode getDiscountCode(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return repository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return repository.findByCampaignId(campaignId);
    }

    @Override
    public DiscountCode deactivateDiscountCode(Long id) {
        DiscountCode code = getDiscountCode(id);
        code.setActive(false);
        return repository.save(code);
    }
}
