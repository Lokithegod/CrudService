package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrudServiceController {

    @Autowired
    CarService carService;

    @GetMapping("/allCars")
    public List<Car> getAllCars() {
        var response = carService.findAllCar();
        return response;
    }

    @GetMapping("/allCars/year/{year}")
    public List<Car> getAllCarsByYear(@PathVariable String year) {
        var response = carService.findCarsByYear(year);
        return response;
    }

    @GetMapping("/allCars/companyName/{companyName}")
    public List<Car> getAllCarsInCompany(@PathVariable String companyName) {
        var response = carService.findCarsByCompanyName(companyName);
        return response;
    }

    @PostMapping("/saveCar")
    public HttpStatus saveCar(@RequestBody Car car) {
        carService.addNewCar(car);
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteCar/{id}")
    public HttpStatus deleteCar(@PathVariable Integer id) {
        carService.deleteCarById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/updateCar/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
        var response = carService.updateCar(id, car);
        return response;
    }


}
