package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.model.Company;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CarService {

    List<Car> findAllCar();

    Car findCarById(int id);

    List<Car> findCarsByYear(int year);

    List<Car> findCarsByCompanyName(String name);

    void deleteCarById(int id);

    void addNewCar(Car car);

    Car updateCar(Integer id, Car car);

    void addCarToCompany (int id, String companyName);

}
