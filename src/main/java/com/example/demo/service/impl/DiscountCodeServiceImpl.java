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
    public DiscountCode create(DiscountCode discountCode) {
        return repository.save(discountCode);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DiscountCode not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = getDiscountCodeById(id);
        existing.setCode(discountCode.getCode());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        return repository.save(existing);
    }

    @Override
    public void deactivate(Long id) {
        DiscountCode code = getDiscountCodeById(id);
        code.setActive(false);
        repository.save(code);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return repository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return repository.findByCampaignId(campaignId);
    }
}
