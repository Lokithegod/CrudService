package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.mapper.CarMapperImpl;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@Validated
public class CrudServiceController {

    @Autowired
    CarService carService;

    @Autowired
    CompanyRepository companyRepository;

    CarMapper carMapper = new CarMapperImpl();

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
    public HttpStatus saveCar(@Valid @RequestBody CarDto car) {
        carService.addNewCar(carMapper.toCarEntity(car));
        return HttpStatus.OK;
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
    public HttpStatus setCarToCompany(@RequestParam Integer carId, @RequestParam String companyName) {
        carService.addCarToCompany(carId, companyName);
        var car = carService.findCarById(carId);
        return HttpStatus.OK;
    }
}
