package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.CarRepository;
import com.example.unicorn.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CarServiceInterface {

    void saveCar(CarEntity carEntity);

    Iterable<CarEntity> getCars();

    CarEntity getCarById(Long id);

    void updateCar(CarEntity carEntity);

    void deleteCarById(Long id);
}