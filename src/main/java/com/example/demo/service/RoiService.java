package com.example.demo.service;

import java.util.List;
import com.example.demo.model.RoiReport;

public interface RoiService {

    RoiReport generateRoiForCode(Long codeId);

    RoiReport getReportById(Long id);

    List<RoiReport> getReportsForInfluencer(Long influencerId);

    List<RoiReport> getReportsForCampaign(Long campaignId);
}
