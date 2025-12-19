package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    SaleTransactionRepository saleTransactionRepository;

    @Override
    public SaleTransaction createTransaction(SaleTransaction transaction) {
        return saleTransactionRepository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getAllTransactions() {
        return saleTransactionRepository.findAll();
    }

    @Override
    public SaleTransaction getTransactionById(Long id) {
        Optional<SaleTransaction> optionalTransaction = saleTransactionRepository.findById(id);
        return optionalTransaction.orElse(null);
    }

    @Override
    public boolean deleteTransaction(Long id) {
        if (saleTransactionRepository.existsById(id)) {
            saleTransactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SaleTransaction logTransaction(SaleTransaction transaction) {
        throw new UnsupportedOperationException("Unimplemented method 'logTransaction'");
    }

    @Override
    public SaleTransaction getSalesForCode(Long codeId) {
        throw new UnsupportedOperationException("Unimplemented method 'getSalesForCode'");
    }

    @Override
    public SaleTransaction getSalesForInfluencer(Long influencerId) {
        throw new UnsupportedOperationException("Unimplemented method 'getSalesForInfluencer'");
    }

    @Override
    public SaleTransaction getSalesForCampaign(long campaignId) {
        throw new UnsupportedOperationException("Unimplemented method 'getSalesForCampaign'");
    }
}
