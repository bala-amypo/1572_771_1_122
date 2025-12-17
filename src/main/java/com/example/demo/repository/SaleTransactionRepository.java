package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SaleTransaction;
@Repository
public interface SaleTransactionRepository extends JpaRepository<SaleTransaction,Long>{

    
}