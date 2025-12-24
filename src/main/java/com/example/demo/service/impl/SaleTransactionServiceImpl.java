// package com.example.demo.service.impl;

// import java.math.BigDecimal;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.DiscountCode;
// import com.example.demo.model.SaleTransaction;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.SaleTransactionService;

// @Service
// public class SaleTransactionServiceImpl implements SaleTransactionService {

//     @Autowired
//     private SaleTransactionRepository saleTransactionRepository;

//     @Autowired
//     private DiscountCodeRepository discountCodeRepository;

//     @Override
//     public SaleTransaction logTransaction(SaleTransaction transaction) {

//         // Rule: saleAmount > 0
//         if (transaction.getSaleAmount() == null ||
//             transaction.getSaleAmount().compareTo(BigDecimal.ZERO) <= 0) {
//             throw new RuntimeException("Sale amount must be greater than zero");
//         }

//         // Attach managed DiscountCode
//         DiscountCode code = discountCodeRepository.findById(
//                 transaction.getDiscountCode().getId()
//         ).orElseThrow(() -> new RuntimeException("Discount code not found"));

//         transaction.setDiscountCode(code);

//         return saleTransactionRepository.save(transaction);
//     }

//     @Override
//     public SaleTransaction getTransactionById(Long id) {
//         return saleTransactionRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForCode(Long codeId) {
//         return saleTransactionRepository.findByDiscountCodeId(codeId);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
//         return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
//     }

//     @Override
//     public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
//         return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
//     }
// }
