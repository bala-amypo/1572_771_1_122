package com.example.ROI.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ROI.model.DiscountCode;
import com.example.ROI.model.RoiReport;
import com.example.ROI.model.SaleTransaction;
import com.example.ROI.repository.DiscountCodeRepository;
import com.example.ROI.repository.RoiReportRepository;
import com.example.ROI.repository.SaleTransactionRepository;
import com.example.ROI.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    @Autowired
    private RoiReportRepository roiReportRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

    // -------------------------------
    // CREATE + CALCULATE ROI
    // -------------------------------
    @Override
    public RoiReport generateRoiForCode(Long codeId) {

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCodeId(codeId);

        BigDecimal totalSales = BigDecimal.valueOf(transactions.size());

        BigDecimal totalRevenue = transactions.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal roiPercentage = BigDecimal.ZERO;
        if (totalSales.compareTo(BigDecimal.ZERO) > 0) {
            roiPercentage = totalRevenue.divide(
                    totalSales, 2, RoundingMode.HALF_UP);
        }

        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());
        report.setInfluencer(code.getInfluencer());
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    // -------------------------------
    // FIXED GET (NO NULL VALUES)
    // -------------------------------
    @Override
    public RoiReport getReportById(Long id) {

        RoiReport report = roiReportRepository.findById(id).orElse(null);
        if (report == null) return null;

        // 🔥 AUTO-FIX OLD / BAD RECORDS
        if (report.getTotalSales() == null || report.getTotalRevenue() == null) {

            List<SaleTransaction> transactions =
                    saleTransactionRepository.findAll();

            BigDecimal totalSales = BigDecimal.valueOf(transactions.size());
            BigDecimal totalRevenue = transactions.stream()
                    .map(SaleTransaction::getSaleAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal roiPercentage = BigDecimal.ZERO;
            if (totalSales.compareTo(BigDecimal.ZERO) > 0) {
                roiPercentage = totalRevenue.divide(
                        totalSales, 2, RoundingMode.HALF_UP);
            }

            report.setTotalSales(totalSales);
            report.setTotalRevenue(totalRevenue);
            report.setRoiPercentage(roiPercentage);

            return roiReportRepository.save(report);
        }

        return report;
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
