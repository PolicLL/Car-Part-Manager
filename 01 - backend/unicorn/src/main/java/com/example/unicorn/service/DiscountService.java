package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.DiscountRepository;
import com.example.unicorn.entity.DiscountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DiscountServiceInterface {

    void saveDiscount(DiscountEntity discountEntity);

    Iterable<DiscountEntity> getDiscounts();

    DiscountEntity getDiscountById(Long id);

    void updateDiscount(DiscountEntity discountEntity);

    void deleteDiscountById(Long id);
}