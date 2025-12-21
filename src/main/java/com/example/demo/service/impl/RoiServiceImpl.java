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

        // 1. Get all sales for the discount code
        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCodeId(codeId);

        // 2. Calculate total revenue
        BigDecimal totalRevenue = transactions.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 3. Calculate total sales count
        BigDecimal totalSales = BigDecimal.valueOf(transactions.size());

        // 4. Calculate ROI (no cost provided in question)
        BigDecimal roiPercentage = totalRevenue;

        // 5. Create ROI report
        RoiReport report = new RoiReport();
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);
        report.setRoiPercentage(roiPercentage);

        // 6. OPTIONAL: set campaign & influencer if sales exist
        if (!transactions.isEmpty()) {
            DiscountCode code = transactions.get(0).getDiscountCode();
            report.setCampaign(code.getCampaign());
            report.setInfluencer(code.getInfluencer());
        }

        // 7. Save & return (generatedAt auto-set)
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
