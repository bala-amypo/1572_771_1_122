package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode code);

    DiscountCode updateDiscountCode(Long id, DiscountCode code);

    DiscountCode getCodeById(Long id);

    List<DiscountCode> getAllCodes();

    boolean deactivateCode(Long id);
}
