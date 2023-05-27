package com.example.unicorn.controller;

import com.example.unicorn.entity.BrandEntity;
import com.example.unicorn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public void saveBrand(@RequestBody BrandEntity brandEntity) {
        brandService.saveBrand(brandEntity);
    }

    @GetMapping
    public Iterable<BrandEntity> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/{id}")
    public BrandEntity getBrand(@PathVariable(value = "id") Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping("/update")
    public void updateBrand(@RequestBody BrandEntity brandEntity) {
        brandService.updateBrand(brandEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrand(@PathVariable(value = "id") Long id) {
        brandService.deleteBrandById(id);
    }
}
