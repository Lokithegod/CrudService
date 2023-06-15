package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class CrudServiceController {

    private final CarService carService;

    private final CarMapper carMapper;

    @GetMapping("/allCars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carMapper.toListCarDto(carService.findAllCar()));
    }

    @GetMapping("/allCars/year/{year}")
    public ResponseEntity<List<CarDto>> getAllCarsByYear(@PathVariable String year) {
        return ResponseEntity.ok(carMapper.toListCarDto((carService.findCarsByYear(year))));
    }

    @GetMapping("/allCars/companyName/{companyName}")
    public ResponseEntity<List<CarDto>> getAllCarsInCompany(@PathVariable String companyName) {
        return ResponseEntity.ok(carMapper.toListCarDto(carService.findCarsByCompanyName(companyName)));
    }

    @PostMapping("/saveCar")
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarDto car) {
        carService.addNewCar(carMapper.toCarEntity(car));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCar/{id}")
    public HttpStatus deleteCar(@PathVariable Integer id) {
        var car = carService.findCarById(id);
        carService.deleteCarById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/updateCar/{id}")
    public HttpStatus updateCar(@PathVariable Integer id, @RequestBody CarDto car) {
        var updatedCar = carService.updateCar(id, carMapper.toCarEntity(car));
        return HttpStatus.OK;
    }

    @PutMapping("/setCarToCompany/")
    public ResponseEntity<?> setCarToCompany(@RequestParam Integer carId, @RequestParam String companyName) {
        carService.addCarToCompany(carId, companyName);
        var car = carService.findCarById(carId);
        return ResponseEntity.ok().build();
    }
}
