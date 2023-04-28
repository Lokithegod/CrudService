package com.gmail.kss95kss.CrudService.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.model.Company;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

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
    private String name;
    private String type;
    private String model;
    private String year;
    private int mileage;
    private int price;
    private String equipment;
    private String about;
    private Double rating;
    private String vin_code;

}
