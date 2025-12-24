// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Campaign;
// import com.example.demo.model.DiscountCode;
// import com.example.demo.model.Influencer;
// import com.example.demo.repository.CampaignRepository;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.repository.InfluencerRepository;
// import com.example.demo.service.DiscountCodeService;

// @Service
// public class DiscountCodeServiceImpl implements DiscountCodeService {

//     @Autowired
//     private DiscountCodeRepository discountCodeRepository;

//     @Autowired
//     private InfluencerRepository influencerRepository;

//     @Autowired
//     private CampaignRepository campaignRepository;

//     @Override
//     public DiscountCode createDiscountCode(DiscountCode code) {

//         if (discountCodeRepository.existsByCode(code.getCode())) {
//             throw new RuntimeException("Discount code already exists");
//         }

//         Influencer influencer = influencerRepository.findById(
//                 code.getInfluencer().getId()
//         ).orElseThrow(() -> new RuntimeException("Influencer not found"));

//         Campaign campaign = campaignRepository.findById(
//                 code.getCampaign().getId()
//         ).orElseThrow(() -> new RuntimeException("Campaign not found"));

//         code.setInfluencer(influencer);
//         code.setCampaign(campaign);

//         return discountCodeRepository.save(code);
//     }

//     @Override
//     public DiscountCode updateDiscountCode(Long id, DiscountCode updatedCode) {

//         DiscountCode existing = discountCodeRepository.findById(id).orElse(null);
//         if (existing == null) return null;

//         existing.setDiscountPercentage(updatedCode.getDiscountPercentage());
//         existing.setActive(updatedCode.getActive());

//         return discountCodeRepository.save(existing);
//     }

//     @Override
//     public DiscountCode getCodeById(Long id) {
//         return discountCodeRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<DiscountCode> getAllCodes() {
//         return discountCodeRepository.findAll();
//     }

//     @Override
//     public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
//         return discountCodeRepository.findByInfluencerId(influencerId);
//     }

//     @Override
//     public List<DiscountCode> getCodesByCampaign(Long campaignId) {
//         return discountCodeRepository.findByCampaignId(campaignId);
//     }

//     @Override
//     public boolean deactivateCode(Long id) {
//         DiscountCode code = discountCodeRepository.findById(id).orElse(null);
//         if (code == null) return false;

//         code.setActive(false);
//         discountCodeRepository.save(code);
//         return true;
//     }
// }
