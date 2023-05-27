package com.example.unicorn.controller;

import com.example.unicorn.entity.DiscountEntity;
import com.example.unicorn.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping
    public void saveDiscount(@RequestBody DiscountEntity discountEntity) {
        discountService.saveDiscount(discountEntity);
    }

    @GetMapping
    public Iterable<DiscountEntity> getDiscounts() {
        return discountService.getDiscounts();
    }

    @GetMapping("/{id}")
    public DiscountEntity getDiscount(@PathVariable(value = "id") Long id) {
        return discountService.getDiscountById(id);
    }

    @PutMapping("/update")
    public void updateDiscount(@RequestBody DiscountEntity discountEntity) {
        discountService.updateDiscount(discountEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDiscount(@PathVariable(value = "id") Long id) {
        discountService.deleteDiscountById(id);
    }
}
