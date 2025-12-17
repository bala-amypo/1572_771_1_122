package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Influencer;

public interface InfluencerService {
    Influencer creatInfluencer(Influencer influencer);
    Influencer updatInfluencer(Long id,Influencer influencer);
    Influencer getInfluencer(Long id);
    List<Influencer>getAllInfluencers();
    void deactivateInfluencer(Long id);


}
