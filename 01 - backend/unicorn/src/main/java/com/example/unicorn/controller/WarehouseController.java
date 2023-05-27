package com.example.unicorn.controller;

import com.example.unicorn.entity.WarehouseEntity;
import com.example.unicorn.entity.json.CarPartReport;
import com.example.unicorn.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public void saveWarehouse(@RequestBody WarehouseEntity warehouseEntity) {
        warehouseService.saveWarehouse(warehouseEntity);
    }

    @GetMapping
    public Iterable<WarehouseEntity> getWarehouses() {
        return warehouseService.getWarehouses();
    }

    @GetMapping("/{id}")
    public WarehouseEntity getWarehouse(@PathVariable(value = "id") Long id) {
        return warehouseService.getWarehouse(id);
    }

    @GetMapping("/{warehouseId}/count/{brandName}/{carName}")
    public CarPartReport getCountOfCarPartsInWarehouse(
            @PathVariable Long warehouseId,
            @PathVariable String brandName,
            @PathVariable String carName) {
        return warehouseService.getCountOfCarPartsInWarehouse(warehouseId, brandName, carName);
    }

    @GetMapping("/search")
    public List<CarPartEntity> getCarPartsByStartEndDate(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return warehouseService.getCarPartsByStartEndDate(startDate, endDate);
    }

    @GetMapping("/search/{brandName}/{carName}")
    public List<CarPartEntity> getCarPartsByCarAndBrandName(
            @PathVariable String brandName,
            @PathVariable String carName) {
        return warehouseService.getCarPartsByCarAndBrandName(brandName, carName);
    }

    @GetMapping("/update")
    public void updateWarehouse(@RequestBody WarehouseEntity warehouseEntity) {
        warehouseService.updateWarehouse(warehouseEntity);
    }

    @GetMapping("/delete/{id}")
    public void deleteWarehouse(@PathVariable(value = "id") Long id) {
        warehouseService.deleteWarehouse(id);
    }
}
