package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Influencer;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    boolean existsBySocialHandle(String socialHandle);

}
