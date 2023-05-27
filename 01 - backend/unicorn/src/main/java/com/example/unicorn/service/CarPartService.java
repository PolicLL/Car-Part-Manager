package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.CarPartRepository;
import com.example.unicorn.dao.CarRepository;
import com.example.unicorn.entity.CarPartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;

    public void saveCarPart(CarPartEntity carPartEntity) {
        carPartRepository.save(carPartEntity);
    }

    public Iterable<CarPartEntity> getCarParts() {
        return carPartRepository.findAll();
    }

    public CarPartEntity getCarPartById(Long id) {
        Optional<CarPartEntity> tempCarPart = carPartRepository.findById(id);
        return tempCarPart.orElseGet(CarPartEntity::new);
    }

    public void updateCarPart(CarPartEntity carPartEntity) {
        carPartRepository.save(carPartEntity);
    }

    public void deleteCarPartById(Long id) {
        carPartRepository.deleteById(id);
    }
}
