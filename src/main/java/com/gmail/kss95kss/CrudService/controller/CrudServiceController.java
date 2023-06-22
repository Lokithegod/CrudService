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

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carMapper.toListCarDto(carService.findAllCar()));
    }

    @GetMapping("/cars/year")
    public ResponseEntity<List<CarDto>> getAllCarsByYear(@RequestParam int year) {
        return ResponseEntity.ok(carMapper.toListCarDto((carService.findCarsByYear(year))));
    }

    @GetMapping("/cars/company")
    public ResponseEntity<List<CarDto>> getAllCarsInCompany(@RequestParam String companyName) {
        return ResponseEntity.ok(carMapper.toListCarDto(carService.findCarsByCompanyName(companyName)));
    }

    @PostMapping("/cars")
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarDto car) {
        carService.addNewCar(carMapper.toCarEntity(car));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cars")
    public HttpStatus deleteCar(@RequestParam Integer id) {
        var car = carService.findCarById(id);
        carService.deleteCarById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/cars")
    public HttpStatus updateCar(@RequestParam Integer id, @RequestBody CarDto car) {
        var updatedCar = carService.updateCar(id, carMapper.toCarEntity(car));
        return HttpStatus.OK;
    }

    @PutMapping("/cars/setCompany")
    public ResponseEntity<?> setCarToCompany(@RequestParam Integer id, @RequestParam String companyName) {
        carService.addCarToCompany(id, companyName);
        return ResponseEntity.ok().build();
    }
}
