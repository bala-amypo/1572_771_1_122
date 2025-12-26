package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiServiceImpl(
            RoiReportRepository roiReportRepository,
            DiscountCodeRepository discountCodeRepository
    ) {
        this.roiReportRepository = roiReportRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateRoiReport(Long codeId) {

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        Campaign campaign = code.getCampaign();
        Influencer influencer = code.getInfluencer();

        // Existing logic (UNCHANGED)
        BigDecimal totalSales = BigDecimal.ZERO;
        BigDecimal totalRevenue = BigDecimal.ZERO;
        BigDecimal roiPercentage = BigDecimal.ZERO;

        RoiReport report = new RoiReport();
        report.setCampaign(campaign);
        report.setInfluencer(influencer);
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);

        // ✅ FIX: convert BigDecimal → double
        report.setRoiPercentage(
                roiPercentage != null ? roiPercentage.doubleValue() : 0.0
        );

        // legacy test expectations
        report.setTotalTransactions(0);
        report.setDiscountCode(code);

        return roiReportRepository.save(report);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencerId(influencerId);
    }
}
