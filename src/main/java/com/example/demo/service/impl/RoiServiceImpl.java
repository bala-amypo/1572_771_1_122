package com.example.demo.service.impl;

import java.math.BigDecimal;
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
    private SaleTransactionRepository saleTransactionRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Override
    public RoiReport generateRoiForCode(Long codeId) {

        DiscountCode discountCode = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount Code not found"));

        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCodeId(codeId);

        BigDecimal totalRevenue = transactions.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalSales =
                BigDecimal.valueOf(transactions.size());

        BigDecimal roiPercentage = totalRevenue; // cost not provided

        RoiReport report = new RoiReport();
        report.setCampaign(discountCode.getCampaign());
        report.setInfluencer(discountCode.getInfluencer());
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
