package com.example.demo.service;

import com.example.ROI.model.RoiReport;

public interface RoiService {
    RoiReport generateRoiForCode(Long codeId);
    RoiReport getReportById(Long id);
    RoiReport getReportsForInfluencer(Long influencerId);
    RoiReport getReportsForCampaign(Long campaignId);
}
 