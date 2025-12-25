package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final List<Influencer> influencers = new ArrayList<>();

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        influencers.add(influencer);
        return influencer;
    }

    @Override
    public Influencer getInfluencer(Long id) {
        return influencers.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencers;
    }

    @Override
    public void deactivate(Long id) {
        Influencer influencer = getInfluencer(id);
        if (influencer != null) {
            influencer.setActive(false);
        }
    }
}
