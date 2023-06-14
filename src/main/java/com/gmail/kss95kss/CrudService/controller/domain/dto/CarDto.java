package com.gmail.kss95kss.CrudService.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto {

    private int id;
    private CarName name;
    private CarType type;
    private String model;
    private String year;
    private int mileage;
    private int price;
    private String equipment;
    private String about;
    private Double rating;
    private String vin_code;

}
