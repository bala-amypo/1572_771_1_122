package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository influencerRepository;

    // ✅ Constructor injection (REQUIRED)
    public InfluencerServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {

        // ✅ Check uniqueness of socialHandle
        influencerRepository.findBySocialHandle(influencer.getSocialHandle())
                .ifPresent(existing -> {
                    throw new RuntimeException("Duplicate social handle");
                });

        return influencerRepository.save(influencer);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
    }
}
