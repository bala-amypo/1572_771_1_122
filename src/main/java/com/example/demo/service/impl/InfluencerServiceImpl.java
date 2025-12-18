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
        if (influencerRepository.existsBySocialHandle(influencer.getSocialHandle())) {
            throw new IllegalArgumentException("Duplicate socialHandle not allowed");
        }
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Optional<Influencer> existing = influencerRepository.findById(id);

        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Influencer not found");
        }

        Influencer old = existing.get();

        if (!old.getSocialHandle().equals(influencer.getSocialHandle())
                && influencerRepository.existsBySocialHandle(influencer.getSocialHandle())) {
            throw new IllegalArgumentException("Duplicate socialHandle not allowed");
        }

        old.setName(influencer.getName());
        old.setSocialHandle(influencer.getSocialHandle());
        old.setEmail(influencer.getEmail());
        old.setActive(influencer.getActive());

        return influencerRepository.save(old);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        if (influencer == null) {
            throw new IllegalArgumentException("Influencer not found");
        }
        influencer.setActive(false);
        influencerRepository.save(influencer);
    }
}
