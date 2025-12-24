// package com.example.demo.service.impl;

// import com.example.demo.model.Campaign;
// import com.example.demo.service.CampaignService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class CampaignServiceImpl implements CampaignService {

//     private List<Campaign> campaigns = new ArrayList<>();

//     @Override
//     public Campaign updateCampaign(Long id, Campaign campaign) {
//         campaign.setId(id);
//         campaigns.add(campaign);
//         return campaign;
//     }

//     @Override
//     public Campaign getCampaignById(Long id) {
//         return new Campaign(id, "Test Campaign", 10000.0);
//     }

//     @Override
//     public List<Campaign> getAllCampaigns() {
//         return campaigns;
//     }
// }
