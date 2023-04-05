package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name) ;
}
