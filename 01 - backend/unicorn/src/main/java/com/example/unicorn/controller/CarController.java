package com.example.unicorn.controller;

import com.example.unicorn.entity.CarEntity;
import com.example.unicorn.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public void saveCar(@RequestBody CarEntity carEntity) {
        carService.saveCar(carEntity);
    }

    @GetMapping
    public Iterable<CarEntity> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public CarEntity getCar(@PathVariable(value = "id") Long id) {
        return carService.getCarById(id);
    }

    @PutMapping("/update")
    public void updateCar(@RequestBody CarEntity carEntity) {
        carService.updateCar(carEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable(value = "id") Long id) {
        carService.deleteCarById(id);
    }
}
