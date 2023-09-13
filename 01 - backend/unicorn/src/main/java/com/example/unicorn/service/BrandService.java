package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface BrandServiceInterface {

    void saveBrand(BrandEntity brandEntity);

    Iterable<BrandEntity> getBrands();

    BrandEntity getBrandById(Long id);

    void updateBrand(BrandEntity brandEntity);

    void deleteBrandById(Long id);
}