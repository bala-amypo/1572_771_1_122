package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoiReport;
@Repository

public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {

    List<RoiReport> findByInfluencerId(Long influencerId);

    List<RoiReport> findByCampaignId(Long campaignId);
}
