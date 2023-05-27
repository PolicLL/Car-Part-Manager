package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.CarRepository;
import com.example.unicorn.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BrandRepository brandRepository;

    public void saveCar(CarEntity carEntity) {
        if (brandRepository.existsById(carEntity.getBrandEntity().getBrandId()))
            carRepository.save(carEntity);
    }

    public Iterable<CarEntity> getCars() {
        return carRepository.findAll();
    }

    public CarEntity getCarById(Long id) {
        Optional<CarEntity> tempCar = carRepository.findById(id);
        return tempCar.orElseGet(CarEntity::new);
    }

    public void updateCar(CarEntity carEntity) {
        carRepository.save(carEntity);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
