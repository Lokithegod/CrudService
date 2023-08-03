package com.gmail.kss95kss.CrudService.repository.specification;

import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

@AllArgsConstructor
@Getter
public class CarSpecification {

    private final Specification<Car> spec;

    public CarSpecification(CarSearchParams params) {

        spec = Specification
                .where(withYear(params.getYear()))
                .and(withPrice(params.getPrice()))
                .and(withModel(params.getModel()))
                .and(withName(params.getName()))
                .and(withCompanyName(params.getCompanyName()));
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

    static Specification<Car> withCompanyName(String companyName) {
        //return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("model"), model));
        return ((root, query, criteriaBuilder) -> {
            if (companyName == null) {
                return criteriaBuilder.conjunction();
            }
            Join<Company, Car> companyJoin = root.join("companyEntity");
            return criteriaBuilder.equal(companyJoin.get("name"), companyName);
        });
    }

    static Specification<Car> withYear(int year) {
        //  return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("year"), year));

        return ((root, query, criteriaBuilder) -> {
            if (year <= 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("year"), year);
        });

    }

    static Specification<Car> withPrice(int price) {
        //   return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price));

        return ((root, query, criteriaBuilder) -> {
            if (price <= 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
        });
    }


}
