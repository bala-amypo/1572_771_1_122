package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    @Autowired
    RoiReportRepository roiReportRepository;

    @Override
    public RoiReport generateRoiForCode(Long codeId) {
        RoiReport report = new RoiReport();
        report.setId(codeId);
        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        Optional<RoiReport> optionalReport = roiReportRepository.findById(id);
        return optionalReport.orElse(null);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencerId(influencerId);
    }
@Override
public List<RoiReport> getReportsForCampaign(Long campaignId) {
    return roiReportRepository.findByCampaignId(campaignId);
}

}
