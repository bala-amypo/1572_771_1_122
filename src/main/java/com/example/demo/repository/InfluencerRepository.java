package com.example.ROI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ROI.model.Influencer;
@Repository
public interface InfluencerRepository extends JpaRepository<Influencer,Long>{

    
} 