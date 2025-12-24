// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Campaign;
// import com.example.demo.repository.CampaignRepository;
// import com.example.demo.service.CampaignService;

// @Service
// public class CampaignServiceImpl implements CampaignService {

//     @Autowired
//     private CampaignRepository campaignRepository;

//     @Override
//     public Campaign createCampaign(Campaign campaign) {
//         return campaignRepository.save(campaign);
//     }

//     @Override
//     public List<Campaign> getAllCampaigns() {
//         return campaignRepository.findAll();
//     }

//     @Override
//     public Campaign getCampaignById(Long id) {
//         return campaignRepository.findById(id).orElse(null);
//     }

//     @Override
//     public Campaign updateCampaign(Long id, Campaign updatedCampaign) {
//         Optional<Campaign> optionalCampaign = campaignRepository.findById(id);

//         if (optionalCampaign.isPresent()) {
//             Campaign oldCampaign = optionalCampaign.get();
//             oldCampaign.setCampaignName(updatedCampaign.getCampaignName());
//             oldCampaign.setStartDate(updatedCampaign.getStartDate());
//             oldCampaign.setEndDate(updatedCampaign.getEndDate());
//             oldCampaign.setBudget(updatedCampaign.getBudget());
//             return campaignRepository.save(oldCampaign);
//         }
//         return null;
//     }

//     @Override
//     public boolean deactivateCampaign(Long id) {
//         Optional<Campaign> optionalCampaign = campaignRepository.findById(id);

//         if (optionalCampaign.isPresent()) {
//             Campaign campaign = optionalCampaign.get();
//             campaign.setActive(false);
//             campaignRepository.save(campaign);
//             return true;
//         }
//         return false;
//     }
// }
