package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepositoryCrud extends PagingAndSortingRepository<Car, Long>, JpaSpecificationExecutor<Car> {


    Page<Car> findByYear(int year, Pageable pageable);

    Page<Car> findByCompanyEntityName(String Name, Pageable pageable);

    void deleteCarById(Integer id);

    Car findCarById(Integer id);

    Boolean existsByVin(String vin);

    default List<Car> findAllByNameAndModelAndYearAndPrice(CarName name, int year, int price, String model) {

        var specification = Specification
                .where(withName(name))
                .and(withModel(model))
                .and(withYear(year))
                .and(withPrice(price));
        return findAll(specification);
    }

    static Specification<Car> withName(CarName name) {
        return ((root, query, criteriaBuilder) -> {
            if (name == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("name"), name);
        });
    }

    static Specification<Car> withModel(String model) {
        //return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("model"), model));
        return ((root, query, criteriaBuilder) -> {
            if (model == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("model"), model);
        });
    }

    static Specification<Car> withYear(int year) {
        //return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("year"), year));
        return ((root, query, criteriaBuilder) -> {
            if (year <= 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("year"), year);
        });

    }

    static Specification<Car> withPrice(int price) {
        //return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price));

        return ((root, query, criteriaBuilder) -> {
            if (price <= 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
        });

    }


}
