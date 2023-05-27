package com.example.unicorn.service;

import com.example.unicorn.dao.BrandRepository;
import com.example.unicorn.dao.CarPartRepository;
import com.example.unicorn.dao.CarRepository;
import com.example.unicorn.dao.WarehouseRepository;
import com.example.unicorn.entity.BrandEntity;
import com.example.unicorn.entity.CarEntity;
import com.example.unicorn.entity.CarPartEntity;
import com.example.unicorn.entity.WarehouseEntity;
import com.example.unicorn.entity.json.CarPartReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarPartRepository carPartRepository;

    public void saveWarehouse(WarehouseEntity warehouseEntity) {
        warehouseRepository.save(warehouseEntity);
    }

    public Iterable<WarehouseEntity> getWarehouses() {
        return warehouseRepository.findAll();
    }

    public WarehouseEntity getWarehouse(Long id) {
        Optional<WarehouseEntity> tempWarehouse = warehouseRepository.findById(id);
        return tempWarehouse.orElseGet(WarehouseEntity::new);
    }

    public CarPartReport getCountOfCarPartsInWarehouse(Long warehouseId, String brandName, String carName) {
        CarPartReport carPartsReport = new CarPartReport();

        try {
            BrandEntity tempBrandEntity = brandRepository.findBrandByBrandName(brandName);
            CarEntity tempCarEntity = carRepository.findCarByCarName(carName);
            WarehouseEntity warehouseEntity = warehouseRepository.findById(warehouseId).orElse(null);

            if (doesBrandContainsCar(tempBrandEntity, tempCarEntity)) {
                return createCarPartReport(tempCarEntity, tempBrandEntity, warehouseEntity);
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }

        return carPartsReport;
    }

    private CarPartReport createCarPartReport(CarEntity tempCarEntity, BrandEntity tempBrandEntity, WarehouseEntity warehouseEntity) {
        CarPartReport carPartsReport = new CarPartReport();

        carPartsReport.setCarName(tempCarEntity.getName());
        carPartsReport.setBrandName(tempBrandEntity.getName());
        carPartsReport.setCount(getNumberOfCarPartsInWarehouse(tempCarEntity, warehouseEntity));

        return carPartsReport;
    }

    public List<CarPartEntity> getCarPartsByStartEndDate(LocalDate startDate, LocalDate endDate) {
        return carPartRepository.findByStartBeforeAndEndAfter(startDate, endDate);
    }

    public List<CarPartEntity> getCarPartsByCarAndBrandName(String brandName, String carName) {
        try {
            BrandEntity tempBrandEntity = brandRepository.findBrandByBrandName(brandName);
            CarEntity tempCarEntity = carRepository.findCarByCarName(carName);

            if (doesBrandContainsCar(tempBrandEntity, tempCarEntity)) {
                return carRepository.findCarByCarName(carName).getCarPartEntities();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private int getNumberOfCarPartsInWarehouse(CarEntity carEntity, WarehouseEntity warehouseEntity) {
        List<CarPartEntity> carPartEntities = carEntity.getCarPartEntities();

        int numberOfCarPartsInWarehouse = 0;

        for (CarPartEntity carPart : carPartEntities) {
            if (isCarPartInWarehouse(carPart, warehouseEntity)) {
                ++numberOfCarPartsInWarehouse;
            }
        }

        return numberOfCarPartsInWarehouse;
    }

    private boolean isCarPartInWarehouse(CarPartEntity carPart, WarehouseEntity warehouseEntity) {
        return carPart.getWarehouseEntity().getWarehouseId() == warehouseEntity.getWarehouseId();
    }

    private boolean doesBrandContainsCar(BrandEntity tempBrandEntity, CarEntity tempCarEntity) {
        return tempBrandEntity.getCarEntities().contains(tempCarEntity);
    }

    public void updateWarehouse(WarehouseEntity warehouseEntity) {
        warehouseRepository.save(warehouseEntity);
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
