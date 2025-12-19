package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        return discountCodeRepository.save(code);
    }

    @Override
    public DiscountCode getCodeById(Long id) {
        return discountCodeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DiscountCode> getAllCodes() {
        return discountCodeRepository.findAll();
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode updatedCode) {
        Optional<DiscountCode> optionalCode = discountCodeRepository.findById(id);

        if (optionalCode.isPresent()) {
            DiscountCode oldCode = optionalCode.get();
            oldCode.setCode(updatedCode.getCode());
            oldCode.setDiscountPercentage(updatedCode.getDiscountPercentage());
            oldCode.setInfluencer(updatedCode.getInfluencer());
            oldCode.setCampaign(updatedCode.getCampaign());
            return discountCodeRepository.save(oldCode);
        }
        return null;
    }

    @Override
    public boolean deactivateCode(Long id) {
        Optional<DiscountCode> optionalCode = discountCodeRepository.findById(id);

        if (optionalCode.isPresent()) {
            DiscountCode code = optionalCode.get();
            code.setActive(false);
            discountCodeRepository.save(code);
            return true;
        }
        return false;
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaignId(campaignId);
    }
}
