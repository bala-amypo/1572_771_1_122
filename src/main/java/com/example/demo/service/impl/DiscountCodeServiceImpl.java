package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode discountCode) {
        discountCodeRepository.findByCode(discountCode.getCode())
                .ifPresent(dc -> {
                    throw new IllegalArgumentException("Discount code already exists");
                });
        return discountCodeRepository.save(discountCode);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Discount code not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = getDiscountCodeById(id);
        existing.setCode(discountCode.getCode());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        return discountCodeRepository.save(existing);
    }

    @Override
    public DiscountCode deactivateDiscountCode(Long id) {
        DiscountCode code = getDiscountCodeById(id);
        code.setActive(false);
        return discountCodeRepository.save(code);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaignId(campaignId);
    }
}
