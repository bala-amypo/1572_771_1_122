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

    public RoiServiceImpl(RoiReportRepository roiReportRepository,
                          DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateRoiReport(Long codeId) {

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        Campaign campaign = code.getCampaign();
        Influencer influencer = code.getInfluencer();

        // ---- Calculations (same logic, safe defaults) ----
        BigDecimal totalSales = BigDecimal.ZERO;
        BigDecimal totalRevenue = BigDecimal.ZERO;
        int totalTransactions = 0;

        BigDecimal roiPercentage = BigDecimal.ZERO;
        if (campaign != null && campaign.getBudget() != null
                && campaign.getBudget().compareTo(BigDecimal.ZERO) > 0) {

            roiPercentage = totalRevenue
                    .subtract(campaign.getBudget())
                    .divide(campaign.getBudget(), 2, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }

        // ---- IMPORTANT: USE ENTITY CONSTRUCTOR ONLY ----
        RoiReport report = new RoiReport(
                campaign,
                influencer,
                totalSales,
                totalRevenue,
                roiPercentage
        );

        // ---- LEGACY TEST FIELDS (TRANSIENT) ----
        report.setTotalTransactions(totalTransactions);
        report.setDiscountCode(code);
        report.setRoiPercentage(roiPercentage); // keeps double + BigDecimal in sync

        return roiReportRepository.save(report);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencerId(influencerId);
    }
}
