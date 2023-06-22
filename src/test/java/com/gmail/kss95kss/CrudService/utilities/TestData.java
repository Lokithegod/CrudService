package com.gmail.kss95kss.CrudService.utilities;

import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.model.Company;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.kss95kss.CrudService.controller.domain.validation.CarName.AUDI;
import static com.gmail.kss95kss.CrudService.controller.domain.validation.CarName.BMW;
import static com.gmail.kss95kss.CrudService.controller.domain.validation.CarType.CROSSOVER;

@UtilityClass
public class TestData {

    public List<Car> getCars() {
        var car = Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("Q5")
                .type(CROSSOVER)
                .name(AUDI)
                .companyEntity(Company.builder()
                        .about("trash")
                        .name("Baza")
                        .address("Kuiv")
                        .rating(5.0)
                        .build())
                .vin("JH4DA9390MS033554")
                .year(2016)
                .build();
        var car2 = Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("X5")
                .type(CROSSOVER)
                .name(BMW)
                .companyEntity(Company.builder()
                        .about("trash")
                        .name("Baza")
                        .address("Kuiv")
                        .rating(5.0)
                        .build())
                .vin("JH4DA9390MS033554")
                .year(2015)
                .build();
        List<Car> cars = new ArrayList<Car>();
        for (int i = 1; i <= 5; i++) {
            cars.add(car);
            cars.add(car2);
        }
        return cars;
    }

    public List<Car> getCarsByYear() {
        var car2 = Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("Q5")
                .type(CROSSOVER)
                .name(AUDI)
                .companyEntity(Company.builder()
                        .about("trash")
                        .name("Baza")
                        .address("Kuiv")
                        .rating(5.0)
                        .build())
                .vin("JH4DA9390MS033554")
                .year(2016)
                .build();
        List<Car> cars = new ArrayList<Car>();
        cars.add(car2);
        return cars;
    }

    public List<Car> addInToGetCars(Car car) {
        var response = getCars();
        response.add(car);
        return response;
    }

    public Car getCar() {
        return getCar(1);
    }

    public Car getCar(int id) {
        return Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("Q5")
                .type(CROSSOVER)
                .name(AUDI)
                .companyEntity(Company.builder()
                        .about("trash")
                        .name("Baza")
                        .address("Kuiv")
                        .rating(5.0)
                        .build())
                .vin("JH4DA9390MS033554")
                .year(2016)
                .id(id)
                .build();
    }

    public Car getCar(String vin) {
        return Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("Q5")
                .type(CROSSOVER)
                .name(AUDI)
                .companyEntity(Company.builder()
                        .about("trash")
                        .name("Baza")
                        .address("Kuiv")
                        .rating(5.0)
                        .build())
                .vin(vin)
                .year(2016)
                .id(3)
                .build();
    }

    public Car getCarWithEmptyCompany() {
        return Car.builder()
                .rating(5.1)
                .about("trash")
                .equipment("SEL")
                .price(16500)
                .mileage(350)
                .model("Q5")
                .type(CROSSOVER)
                .name(AUDI)
                .vin("JH4DA9390MS033554")
                .year(2016)
                .id(0)
                .build();
    }

    public Company getCompany() {
        return Company.builder()
                .rating(5.0)
                .address("Kiev")
                .about("Trash")
                .name("Baza")
                .build();
    }
}
