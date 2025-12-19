package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DiscountCode;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    List<DiscountCode> findByInfluencerId(Long influencerId);

    List<DiscountCode> findByCampaignId(Long campaignId);
}
