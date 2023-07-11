package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.controller.domain.dto.PageDto;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.mapper.PageToPageDtoMapper;
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

    private final CarMapper carMapper;

    private final PageToPageDtoMapper pageDtoMapper;

    private final PageSettings pageSettings;

    @GetMapping("/cars")
    public ResponseEntity getAllCars(@RequestParam int page,
                                             @RequestParam int elementPerPage,
                                             @RequestParam(required = false) CarName name,
                                             @RequestParam(required = false, defaultValue = "1850") int year,
                                             @RequestParam(required = false) String model,
                                             @RequestParam(required = false,defaultValue = "999999999") int price) {
        pageSettings.setPage(page);
        pageSettings.setElementPerPage(elementPerPage);
        PageDto carsPage = pageDtoMapper.pageToPageDto(carService.findCarsByCriteria(name,year,price,model,pageSettings));
        LOG.info("Request for car page received with data : " + pageSettings);
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
        carService.addNewCar(carMapper.toCarEntity(car));
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
