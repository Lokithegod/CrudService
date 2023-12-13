package com.gmail.kss95kss.CrudService.repository.specification;

import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
public class CarSearchParams {

    private CarName name;
    private int year;
    private int price;
    private String model;
    private String companyName;
}
