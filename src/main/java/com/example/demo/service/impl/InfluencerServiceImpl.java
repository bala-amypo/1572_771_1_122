package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final List<Influencer> influencers = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        // Check duplicate username
        if (influencers.stream().anyMatch(i -> i.getUsername().equals(influencer.getUsername()))) {
            throw new IllegalArgumentException("Duplicate username not allowed");
        }
        influencer.setId(idGenerator.getAndIncrement());
        influencer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        influencer.setActive(true);
        influencers.add(influencer);
        return influencer;
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = getInfluencerById(id);
        if (existing == null) return null;

        // Check duplicate username (except itself)
        if (!existing.getUsername().equals(influencer.getUsername()) &&
            influencers.stream().anyMatch(i -> i.getUsername().equals(influencer.getUsername()))) {
            throw new IllegalArgumentException("Duplicate username not allowed");
        }

        existing.setUsername(influencer.getUsername());
        existing.setFullName(influencer.getFullName());
        existing.setNiche(influencer.getNiche());
        existing.setPlatform(influencer.getPlatform());
        existing.setProfileUrl(influencer.getProfileUrl());
        existing.setActive(influencer.getActive());
        // createdAt remains unchanged

        return existing;
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencers.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return new ArrayList<>(influencers);
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        if (influencer != null) {
            influencer.setActive(false);
        }
    }
}