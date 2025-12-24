package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {
    RoiReport generateRoiReport(Long campaignId);
    List<RoiReport> getAllRoiReports();
}
