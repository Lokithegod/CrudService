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
import java.util.Timer;

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
    public ResponseEntity getAllCars(@RequestParam(value = "page") int page,
                                     @RequestParam(value = "elementPerPage") int elementPerPage,
                                     @RequestParam(required = false, value = "name") CarName name,
                                     @RequestParam(required = false, value = "year", defaultValue = "2025") int year,
                                     @RequestParam(required = false, value = "model") String model,
                                     @RequestParam(required = false, value = "price", defaultValue = "999999999") int price,
                                     @RequestParam(required = false, value = "company") String companyName) {
        var startTimer = System.nanoTime();
        LOG.info("Operation: search");
        pageSettings.setPage(page);
        pageSettings.setElementPerPage(elementPerPage);
        var carsPage = pageDtoMapper.pageToPageDto(carSearchService.findCarsByCriteria(name, year, price, model, companyName, pageSettings));
        LOG.info("Request for car page received with data : " + pageSettings);
        var endTimer = System.nanoTime();
        var operationTime = (endTimer-startTimer)/1000000;
        LOG.info("OPERATION TIME: {} millisecond",operationTime);
        return ResponseEntity.ok().body(carsPage);
    }


/*    @GetMapping("/cars?year=")
    public ResponseEntity<List<CarDto> getAllCarsByYear(@RequestParam int year) {
        return ResponseEntity.ok(carMapper.toListCarDto((carService.findCarsByYear(year))));
    }

    @GetMapping("/cars?company=")
    public ResponseEntity<Page<CarDto>> getAllCarsInCompany(@RequestParam String company) {
        return ResponseEntity.ok(carMapper.toListCarDto(carService.findCarsByCompanyName(company)));
    }*/

    @PostMapping("/cars")
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarDto car) {
        var startTimer = System.nanoTime();
        carService.addNewCar(carMapper.toCarEntity(car));
        var endTimer = System.nanoTime();
        var operationTime = (endTimer-startTimer)/1000000;
        LOG.info("OPERATION TIME: {} millisecond",operationTime);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cars/{id}")
    public HttpStatus deleteCar(@PathVariable Integer id) {
        var car = carService.findCarById(id);
        carService.deleteCarById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/cars/{id}")
    public HttpStatus updateCar(@PathVariable Integer id, @RequestBody CarDto car) {
        var updatedCar = carService.updateCar(id, car);
        return HttpStatus.OK;
    }

    @PutMapping("/cars/setCompany")
    public ResponseEntity<?> setCarToCompany(@RequestParam Integer id, @RequestParam String companyName) {
        carService.addCarToCompany(id, companyName);
        return ResponseEntity.ok().build();
    }
}
