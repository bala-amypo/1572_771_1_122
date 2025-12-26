package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeService(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    // ✅ REQUIRED BY TEST
    public DiscountCode getDiscountCodeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ REQUIRED BY TEST
    public DiscountCode updateDiscountCode(Long id, Object payload) {
        DiscountCode existing = repository.findById(id).orElse(null);
        if (existing != null && payload instanceof DiscountCode) {
            DiscountCode updated = (DiscountCode) payload;
            existing.setCode(updated.getCode());
            existing.setDiscountPercentage(updated.getDiscountPercentage());
            return repository.save(existing);
        }
        return null;
    }

    // ✅ REQUIRED BY TEST
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return repository.findByInfluencer_Id(influencerId);
    }

    // ✅ REQUIRED BY TEST
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return repository.findByCampaign_Id(campaignId);
    }
}
