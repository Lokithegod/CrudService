package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CarService {

    List<Car> findAllCar ();
    List<Car> findCarsByYear (String year);
    List<Car> findCarsByCompanyName (String name);
    void addNewCar (Car car);
}
