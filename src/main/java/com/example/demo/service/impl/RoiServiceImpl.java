package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    @Autowired
    private RoiReportRepository roiReportRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

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
            roiPercentage = totalRevenue
                    .divide(totalSales, 2, RoundingMode.HALF_UP);
        }

        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());
        report.setInfluencer(code.getInfluencer());
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiReportRepository.findById(id).orElse(null);
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
