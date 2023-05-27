package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.DiscountRepository;
import com.example.unicorn.entity.DiscountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private BrandRepository brandRepository;

    public void saveDiscount(DiscountEntity discountEntity) {
        discountRepository.save(discountEntity);
    }

    public Iterable<DiscountEntity> getDiscounts() {
        return discountRepository.findAll();
    }

    public DiscountEntity getDiscountById(Long id) {
        Optional<DiscountEntity> tempDiscount = discountRepository.findById(id);
        return tempDiscount.orElseGet(DiscountEntity::new);
    }

    public void updateDiscount(DiscountEntity discountEntity) {
        discountRepository.save(discountEntity);
    }

    public void deleteDiscountById(Long id) {
        discountRepository.deleteById(id);
    }
}
