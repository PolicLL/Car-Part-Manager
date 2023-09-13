package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.CarPartRepository;
import com.example.unicorn.dao.CarRepository;
import com.example.unicorn.entity.CarPartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CarPartServiceInterface {

    void saveCarPart(CarPartEntity carPartEntity);

    Iterable<CarPartEntity> getCarParts();

    CarPartEntity getCarPartById(Long id);

    void updateCarPart(CarPartEntity carPartEntity);

    void deleteCarPartById(Long id);
}