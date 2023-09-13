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

public interface WarehouseServiceInterface {

    void saveWarehouse(WarehouseEntity warehouseEntity);

    Iterable<WarehouseEntity> getWarehouses();

    WarehouseEntity getWarehouse(Long id);

    CarPartReport getCountOfCarPartsInWarehouse(Long warehouseId, String brandName, String carName);

    List<CarPartEntity> getCarPartsByStartEndDate(LocalDate startDate, LocalDate endDate);

    List<CarPartEntity> getCarPartsByCarAndBrandName(String brandName, String carName);

    void updateWarehouse(WarehouseEntity warehouseEntity);

    void deleteWarehouse(Long id);
}