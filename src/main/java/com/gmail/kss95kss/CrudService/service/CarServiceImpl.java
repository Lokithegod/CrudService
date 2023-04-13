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
        LOG.info("Search cars");
        var cars = carRepository.findAll();
        return cars;
    }

    @Override
    public Car findCarById(int id) {
        return carRepository.findCarById(id);
    }

    @Override
    public List<Car> findCarsByYear(String year) {
        LOG.info("Search cars by {} year", year);
        var cars = carRepository.findByYear(year);
        return cars;
    }

    @Override
    public List<Car> findCarsByCompanyName(String name) {
        LOG.info("Search cars by company name: {}  ", name);
        var cars = carRepository.findByCompanyEntityName(name);
        return cars;
    }

    @Override
    public void deleteCarById(Integer id) {
        var actual = carRepository.findCarById(id);
        carRepository.delete(actual);
        LOG.info("Car {} was sold ", actual);

    }

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
        LOG.info("Car {} was saved ", car);

    }

    public Car updateCar(Integer id, Car car) {
        var actual = carRepository.findCarById(id);
        actual = car;
        actual.setId(id);
        carRepository.save(actual);
        LOG.info("Car with id:{} was updated with params {}", id, car);
        return actual;
    }
}
