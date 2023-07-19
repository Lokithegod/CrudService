package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.repository.specification.CarSearchParams;
import com.gmail.kss95kss.CrudService.repository.specification.CarSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarSearchRepository extends PagingAndSortingRepository<Car, Long>, JpaSpecificationExecutor<Car> {

    default Page<Car> findCarsByCriteria(CarSearchParams params, Pageable page)
    {
        CarSpecification specification = new CarSpecification(params);
        return findAll(specification.getSpec(), page);
        //return findAll(specification.getSpec());
    }
}
