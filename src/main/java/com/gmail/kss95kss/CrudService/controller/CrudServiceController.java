package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.controller.domain.dto.ServiceOperationResponse;
import com.gmail.kss95kss.CrudService.model.Car;
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

    @GetMapping("/allCars")
    public ResponseEntity<ServiceOperationResponse> getAllCars() {
        return ResponseEntity.ok(new ServiceOperationResponse(carService.findAllCar()));
    }

    @GetMapping("/allCars/year/{year}")
    public ResponseEntity<ServiceOperationResponse> getAllCarsByYear(@PathVariable String year) {
        return ResponseEntity.ok(new ServiceOperationResponse(carService.findCarsByYear(year)));
    }

    @GetMapping("/allCars/companyName/{companyName}")
    public ResponseEntity<ServiceOperationResponse> getAllCarsInCompany(@PathVariable String companyName) {
        return ResponseEntity.ok(new ServiceOperationResponse(carService.findCarsByCompanyName(companyName)));
    }

    @PostMapping("/saveCar")
    public ResponseEntity<ServiceOperationResponse> saveCar(@Valid @RequestBody Car car) {
        carService.addNewCar(car);
        return ResponseEntity.ok(new ServiceOperationResponse(List.of(car)));
    }

    @DeleteMapping("/deleteCar/{id}")
    public HttpStatus deleteCar(@PathVariable Integer id) {
        var car = carService.findCarById(id);
        carService.deleteCarById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<ServiceOperationResponse> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        var updatedCar = carService.updateCar(id, car);
        return ResponseEntity.ok(new ServiceOperationResponse(List.of(updatedCar)));
    }

    @PutMapping("/setCarToCompany/")
    public HttpStatus setCarToCompany(@RequestParam Integer carId, @RequestParam String companyName) {
        carService.addCarToCompany(carId, companyName);
        var car = carService.findCarById(carId);
        return HttpStatus.OK;
    }
}
