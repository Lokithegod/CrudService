package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name);
    List<Car> findByYear(String year);
    List<Car> findByCompanyEntity(int company);
    List<Car> findByCompanyEntityName(String Name);
    Car deleteCarById(Integer id);
    Car findCarById(Integer id);

}
