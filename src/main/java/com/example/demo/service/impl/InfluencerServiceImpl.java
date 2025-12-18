package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    private InfluencerRepository influencerRepository;

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (influencerRepository.existsByUsername(influencer.getUsername())) {
            throw new IllegalArgumentException("Duplicate username not allowed");
        }
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Optional<Influencer> existingOpt = influencerRepository.findById(id);
        if (existingOpt.isPresent()) {
            Influencer old = existingOpt.get();

            // Prevent duplicate username on update (except for itself)
            if (!old.getUsername().equals(influencer.getUsername()) &&
                influencerRepository.existsByUsername(influencer.getUsername())) {
                throw new IllegalArgumentException("Duplicate username not allowed");
            }

            old.setUsername(influencer.getUsername());
            old.setFullName(influencer.getFullName());
            old.setNiche(influencer.getNiche());
            old.setPlatform(influencer.getPlatform());
            old.setProfileUrl(influencer.getProfileUrl());
            old.setActive(influencer.getActive());
            old.setCreatedAt(influencer.getCreatedAt());

            return influencerRepository.save(old);
        }
        return null;
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        Optional<Influencer> influencerOpt = influencerRepository.findById(id);
        return influencerOpt.orElse(null);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        if (influencer != null) {
            influencer.setActive(false);
            influencerRepository.save(influencer);
        }
    }
}