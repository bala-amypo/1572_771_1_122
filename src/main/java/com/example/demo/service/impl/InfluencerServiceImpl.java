package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    private InfluencerRepository repository;

    public Influencer createInfluencer(Influencer influencer) {
        return repository.save(influencer);
    }

    public Influencer updateInfluencer(Long id, Influencer influencer) {
        return repository.findById(id).map(old -> {
            old.setName(influencer.getName());
            old.setEmail(influencer.getEmail());
            old.setSocialHandle(influencer.getSocialHandle());
            return repository.save(old);
        }).orElse(null);
    }

    public Influencer getInfluencerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Influencer> getAllInfluencers() {
        return repository.findAll();
    }

    public boolean deactivateInfluencer(Long id) {
        return repository.findById(id).map(i -> {
            i.setActive(false);
            repository.save(i);
            return true;
        }).orElse(false);
    }
}
