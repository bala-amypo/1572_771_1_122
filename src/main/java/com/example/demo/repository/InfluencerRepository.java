package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Influencer;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    // Used to check uniqueness of socialHandle
    Optional<Influencer> findBySocialHandle(String socialHandle);
}
