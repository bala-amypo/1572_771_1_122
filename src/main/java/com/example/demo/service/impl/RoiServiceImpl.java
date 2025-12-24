package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final List<RoiReport> reports = new ArrayList<>();

    @Override
    public RoiReport generateRoiReport(Long campaignId) {
        // Dummy implementation
        RoiReport report = new RoiReport();
        report.setCampaignId(campaignId);
        report.setRoi(0.0);
        reports.add(report);
        return report;
    }

    @Override
    public List<RoiReport> getAllRoiReports() {
        return reports;
    }
}
