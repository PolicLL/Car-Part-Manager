package com.example.unicorn.controller;

import com.example.unicorn.entity.CarPartEntity;
import com.example.unicorn.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carParts")
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @PostMapping
    public void saveCarPart(@RequestBody CarPartEntity carPartEntity) {
        carPartService.saveCarPart(carPartEntity);
    }

    @GetMapping
    public Iterable<CarPartEntity> getCarParts() {
        return carPartService.getCarParts();
    }

    @GetMapping("/{id}")
    public CarPartEntity getCarPartById(@PathVariable(value = "id") Long id) {
        return carPartService.getCarPartById(id);
    }

    @PutMapping()
    public void updateCarPart(@RequestBody CarPartEntity carPartEntity) {
        carPartService.updateCarPart(carPartEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCarPart(@PathVariable(value = "id") Long id) {
        carPartService.deleteCarPartById(id);
    }
}
