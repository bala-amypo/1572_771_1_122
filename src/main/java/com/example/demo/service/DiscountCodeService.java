package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode getDiscountCodeById(Long id);

    List<DiscountCode> getAllCodes();
}
