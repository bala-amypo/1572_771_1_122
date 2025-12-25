package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {

        campaignRepository.findByCampaignName(campaign.getCampaignName())
                .ifPresent(c -> {
                    throw new IllegalArgumentException("Campaign name already exists");
                });

        validateCampaign(campaign);

        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        Campaign existing = getCampaignById(id);

        validateCampaign(campaign);

        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(campaign.getStartDate());
        existing.setEndDate(campaign.getEndDate());
        existing.setBudget(campaign.getBudget());

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign deactivateCampaign(Long id) {
        Campaign campaign = getCampaignById(id);
        campaign.setActive(false);
        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    private void validateCampaign(Campaign campaign) {
        if (campaign.getStartDate().isAfter(campaign.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        if (campaign.getBudget() == null ||
            campaign.getBudget().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Budget must be greater than zero");
        }
    }
}
