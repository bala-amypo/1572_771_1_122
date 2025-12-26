package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    // Existing
    List<RoiReport> getReportsForInfluencer(Long influencerId);

    // ✅ NEW
    List<RoiReport> getReportsForCampaign(Long campaignId);
}
