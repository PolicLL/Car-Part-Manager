package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void saveBrand(BrandEntity brandEntity) {
        brandRepository.save(brandEntity);
    }

    public Iterable<BrandEntity> getBrands() {
        return brandRepository.findAll();
    }

    public BrandEntity getBrandById(Long id) {
        Optional<BrandEntity> tempBrand = brandRepository.findById(id);
        return tempBrand.orElseGet(BrandEntity::new);
    }

    public void updateBrand(BrandEntity brandEntity) {
        brandRepository.save(brandEntity);
    }

    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
