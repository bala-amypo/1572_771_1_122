package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repo;

    public InfluencerServiceImpl(InfluencerRepository repo) {
        this.repo = repo;
    }

    public Influencer createInfluencer(Influencer influencer) {
        repo.findBySocialHandle(influencer.getSocialHandle())
                .ifPresent(i -> { throw new RuntimeException("Duplicate social handle"); });
        return repo.save(influencer);
    }

    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = getInfluencer(id);
        existing.setName(influencer.getName());
        existing.setEmail(influencer.getEmail());
        return repo.save(existing);
    }

    public Influencer getInfluencer(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
    }

    public List<Influencer> getAll() {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        Influencer inf = getInfluencer(id);
        inf.setActive(false);
        repo.save(inf);
    }
}
