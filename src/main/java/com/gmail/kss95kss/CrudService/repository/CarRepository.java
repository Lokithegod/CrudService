package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPublished(boolean published) ;

    List<Car> findByCompanyName(String name) ;
}
