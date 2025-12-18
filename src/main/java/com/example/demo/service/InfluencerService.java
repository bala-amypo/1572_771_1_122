package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Influencer;

public interface InfluencerService {

    Influencer createInfluencer(Influencer influencer);

    List<Influencer> getAllInfluencers();

    Influencer getInfluencerById(Long id);
}
