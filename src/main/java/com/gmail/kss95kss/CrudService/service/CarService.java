package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CarService {

    List<Car> findAllCar ();
    List<Car> findCarsByYear (int year);
    List<Car> findCarsByCompanyName (String name);
    void addNewCar (String name,String type,String model,int year,int mileage,int price,String equipment,String about,Double rating);
}
