package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service   // ⭐ THIS IS CRITICAL
public class InfluencerServiceImpl implements InfluencerService {

    private final List<Influencer> influencers = new ArrayList<>();

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        influencer.setId((long) (influencers.size() + 1));
        influencers.add(influencer);
        return influencer;
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
        return influencers;
    }
}
