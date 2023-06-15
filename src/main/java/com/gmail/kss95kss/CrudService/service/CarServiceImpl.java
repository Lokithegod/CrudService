package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.exception.*;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.repository.CarRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    private final CompanyRepository companyRepository;

    private static final int carInCompany = 10;

    @Override
    public List<Car> findAllCar() {
        LOG.info("Search cars");
        return carRepository.findAll();
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
        if (companyRepository.findCompanyByName(name) != null) {
            LOG.info("Search cars by company name: {}  ", name);
            var cars = carRepository.findByCompanyEntityName(name);
            return cars;
        } else
            throw new CompanyNotFoundException();
    }

    @Override
    @Transactional
    public void deleteCarById(int id) {
        if (carRepository.findCarById(id) != null) {
            carRepository.deleteCarById(id);
            LOG.info("Car was sold ");
        } else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public void addNewCar(Car car) {
        LOG.info("Operation: addNewCar: New Car params :{}", car);
        var allCars = carRepository.findAll();
        boolean mutch = allCars.stream().anyMatch(c -> c.getVin_code().equals(car.getVin_code()));
        if (!mutch) {
            carRepository.save(car);
            LOG.info("Car {} was saved ", car);
        } else {
            throw new DuplicateVinCodeException();
        }
    }

    public Car updateCar(Integer id, Car car) {
        LOG.info("Operation: updateCar: change with params :{}", car);
        var actual = carRepository.findCarById(id);
        if (actual != null) {
            actual = car;
            actual.setId(id);
            var allCars = carRepository.findAll();
            boolean mutch = allCars.stream().anyMatch(c -> c.getVin_code().equals(car.getVin_code()));
            if (!mutch) {
                carRepository.save(actual);
                LOG.info("Car with id:{} was updated with params {}", id, car);
                return actual;
            } else {
                throw new DuplicateVinCodeException();
            }
        } else {
            throw new CarNotFoundException();
        }
    }

    @Override
    public void addCarToCompany(int id, String companyName) {
        LOG.info("Operation: AddCarToCompany:{}", companyName);
        var car = carRepository.findCarById(id);
        if (car != null) {
            LOG.info("Car found :{}", car);
            if (car.getCompanyEntity() != null) {
                throw new CarAlreadyInCompanyException();
            }
            var company = companyRepository.findCompanyByName(companyName);
            if (company != null) {
                if (checkCompanyCars(carRepository.findByCompanyEntityName(companyName))) {
                    car.setCompanyEntity(company);
                    carRepository.save(car);
                } else
                    throw new CompanyCarsIsFullException();
            } else {
                throw new CompanyNotFoundException();
            }
        } else {
            throw new CarNotFoundException();
        }
    }

    private boolean checkCompanyCars(List<Car> cars) {
        if (cars.stream().count() >= carInCompany) {
            return false;
        } else {
            return true;
        }
    }
}
