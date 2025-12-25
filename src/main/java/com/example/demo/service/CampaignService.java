package com.example.ROI.service;

import com.example.ROI.model.Campaign;
import java.util.List;

public interface CampaignService {

    Campaign updateCampaign(Long id, Campaign campaign);

    Campaign getCampaignById(Long id);

    List<Campaign> getAllCampaigns();
}
