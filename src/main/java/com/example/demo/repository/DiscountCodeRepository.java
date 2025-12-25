package com.example.ROI.repository;

import com.example.ROI.model.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    List<DiscountCode> findByInfluencerId(Long influencerId);

    List<DiscountCode> findByCampaignId(Long campaignId);
}
