package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CarService {

    Page<Car> findAllCar(PageSettings settings);

    Page<Car> findCarsByCriteria(CarName name, int year, int price, String model, PageSettings pageSettings);

    Car findCarById(int id);

    Page<Car> findCarsByYear(int year, PageSettings PageSettings);

    Page<Car> findCarsByCompanyName(String name);

    void deleteCarById(int id);

    void addNewCar(Car car);

    CarDto updateCar(Integer id, CarDto car);

    void addCarToCompany(int id, String companyName);

}
