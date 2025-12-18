// src/main/java/com/example/demo/service/InfluencerServiceImpl.java
package com.example.demo.service;

import com.example.demo.model.Influencer;

import com.example.demo.repository.InfluencerRepository;

import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (influencerRepository.findBySocialHandle(influencer.getSocialHandle()).isPresent()) {
            throw new IllegalArgumentException("Duplicate social handle exists");
        }
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = influencerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
        if (!existing.getSocialHandle().equals(influencer.getSocialHandle()) && influencerRepository.findBySocialHandle(influencer.getSocialHandle()).isPresent()) {
            throw new IllegalArgumentException("Duplicate social handle exists");
        }
        existing.setName(influencer.getName());
        existing.setSocialHandle(influencer.getSocialHandle());
        existing.setEmail(influencer.getEmail());
        return influencerRepository.save(existing);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        influencer.setActive(false);
        influencerRepository.save(influencer);
    }
}