package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface InfluencerService {
    Influencer createInfluencer(Influencer influencer);
    Influencer getInfluencerById(Long id);
    List<Influencer> getAllInfluencers();
}
