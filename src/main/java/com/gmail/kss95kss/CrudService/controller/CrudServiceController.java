package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.mapper.PageToPageDtoMapper;
import com.gmail.kss95kss.CrudService.service.CarSearchService;
import com.gmail.kss95kss.CrudService.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class CrudServiceController {

    private final CarService carService;

    private final CarSearchService carSearchService;

    private final CarMapper carMapper;

    private final PageToPageDtoMapper pageDtoMapper;

    private final PageSettings pageSettings;


    @GetMapping("/cars")
    public ResponseEntity getAllCars(@RequestParam(value = "page") Integer page,
                                     @RequestParam(value = "elementPerPage") Integer elementPerPage,
                                     @RequestParam(required = false, value = "name") CarName name,
                                     @RequestParam(required = false, value = "year", defaultValue = "2025") Integer year,
                                     @RequestParam(required = false, value = "model") String model,
                                     @RequestParam(required = false, value = "price", defaultValue = "999999999") Integer price,
                                     @RequestParam(required = false, value = "company") String companyName) {
        var startTimer = System.nanoTime();
        LOG.info("Operation: search");
        pageSettings.setPage(page);
        pageSettings.setElementPerPage(elementPerPage);
        var carsPage = pageDtoMapper.pageToPageDto(carSearchService.findCarsByCriteria(name, year, price, model, companyName, pageSettings));
        LOG.info("Request for car page received with data : " + pageSettings);
        var endTimer = System.nanoTime();
        var operationTime = (endTimer - startTimer) / 1000000;
        LOG.info("OPERATION TIME: {} millisecond", operationTime);
        return ResponseEntity.ok().body(carsPage);
    }


    @PostMapping("/cars")
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarDto car) {
        var startTimer = System.nanoTime();
        carService.addNewCar(carMapper.toCarEntity(car));
        var endTimer = System.nanoTime();
        var operationTime = (endTimer - startTimer) / 1000000;
        LOG.info("OPERATION TIME: {} millisecond", operationTime);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cars")
    public HttpStatus deleteCar(@RequestParam Integer id) {
        var startTimer = System.nanoTime();
        var car = carService.findCarById(id);
        carService.deleteCarById(id);
        var endTimer = System.nanoTime();
        var operationTime = (endTimer - startTimer) / 1000000;
        LOG.info("OPERATION TIME: {} millisecond", operationTime);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/cars")
    public HttpStatus updateCar(@RequestParam Integer id, @RequestBody CarDto car) {
        var startTimer = System.nanoTime();
        var updatedCar = carService.updateCar(id, car);
        var endTimer = System.nanoTime();
        var operationTime = (endTimer - startTimer) / 1000000;
        LOG.info("OPERATION TIME: {} millisecond", operationTime);
        return HttpStatus.OK;
    }

    @PutMapping("/cars/setCompany")
    public ResponseEntity<?> setCarToCompany(@RequestParam Integer id, @RequestParam String companyName) {
        carService.addCarToCompany(id, companyName);
        return ResponseEntity.ok().build();
    }
}
