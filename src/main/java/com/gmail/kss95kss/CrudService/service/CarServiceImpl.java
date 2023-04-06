package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    @Override
    public List<Car> findAllCar() {
        var cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> findCarsByYear(int year) {
        var cars = carRepository.findByYear(year);
        return cars;
    }

    @Override
    public List<Car> findCarsByCompanyName(String name) {
        var cars = carRepository.findByCompanyEntityName(name);
        return cars;
    }

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }
}
